package engineeringthesis.androidrestapi.audio.domain;

import engineeringthesis.androidrestapi.audio.AudioFacade;
import engineeringthesis.androidrestapi.audio.dto.AudioDto;
import engineeringthesis.androidrestapi.audio.dto.AudioFilterForm;
import engineeringthesis.androidrestapi.audio.dto.UpdateAudioForm;
import engineeringthesis.androidrestapi.common.controller.PageDto;
import engineeringthesis.androidrestapi.common.controller.PageableRequest;
import engineeringthesis.androidrestapi.common.controller.PageableUtils;
import engineeringthesis.androidrestapi.common.entity.ReaderPropertiesFile;
import engineeringthesis.androidrestapi.common.exception.FileNotFoundException;
import engineeringthesis.androidrestapi.common.exception.NotFoundException;
import engineeringthesis.androidrestapi.common.validation.DtoValidator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.UUID;

import static engineeringthesis.androidrestapi.audio.domain.AudioService.ErrorMessages.AUDIO_NOT_EXIST;
import static engineeringthesis.androidrestapi.audio.domain.AudioService.ErrorMessages.AUDIO_SAVE_FAIL;


@RequiredArgsConstructor
class AudioService implements AudioFacade {


    private final AudioRepository audioRepository;
    private final ReaderPropertiesFile readerPropertiesFile;
    private final AudioFileTableRepository audioFileTableRepository;

    static final class ErrorMessages {
        static final String AUDIO_NOT_EXIST = "Audio File not found  %s";

        static final String AUDIO_SAVE_FAIL = "Could not save the file";
    }


    @Override
    public PageDto<AudioDto> findAudios(final AudioFilterForm filterForm, final PageableRequest pageableRequest) {
        DtoValidator.validate(filterForm);
        DtoValidator.validate(pageableRequest);

        final AudioSpecification audioSpecification = new AudioSpecification(filterForm);

        final Page<AudioDto> audios = audioRepository.findAll(audioSpecification, PageableUtils.createPageable(pageableRequest))
                .map(this::mapToDto);

        return PageableUtils.toDto(audios);
    }

    @Override
    @Transactional
    public AudioDto saveAudio(final MultipartFile file) {
        Properties prop;
        try {
            prop = readerPropertiesFile.readPropertiesFile("application.properties");
            final Path path = Paths.get(prop.getProperty("audio_save_files_path"));
            Files.write(path.resolve(file.getOriginalFilename()), file.getBytes());

        } catch (Exception e) {
            throw new RuntimeException(AUDIO_SAVE_FAIL);
        }
        final AudioFileTable audioFile = audioFileTableRepository.findByName(file.getOriginalFilename());

        String fileDownloadUri = prop.getProperty("audio_download_uri") + file.getOriginalFilename();

        Audio audio = new Audio();
        audio.setAudioFileTable(audioFile);
        audio.setDownloadUri(fileDownloadUri);
        audio.setIsAccepted(false);
        audio.setIsNew(true);

        return mapToDto(audioRepository.save(audio));
    }

    @Override
    public AudioDto findAudio(final UUID uuid) {
        return audioRepository.findByUuid(uuid)
                .map(this::mapToDto)
                .orElseThrow(() -> new NotFoundException(AUDIO_NOT_EXIST, uuid));
    }

    @Override
    @Transactional
    public void deleteAudio(final UUID uuid) {
        audioRepository.deleteByUuid(uuid);
    }

    @Override
    @Transactional
    public void updateAudio(final UUID uuid, final UpdateAudioForm audioForm) {
        Audio audio = audioRepository.findByUuid(uuid)
                .orElseThrow(() -> new NotFoundException(AUDIO_NOT_EXIST, uuid));

        audio.setDownloadUri(audioForm.downloadUri());
    }

    @Override
    public Resource loadAudioAsResource(final String audioName) {

        try {
            Properties prop = null;
            try {
                prop = readerPropertiesFile.readPropertiesFile("application.properties");
            } catch (IOException e) {
                e.printStackTrace();
            }
            final Path path = Paths.get(prop.getProperty("audio_save_files_path"));
            final Resource resource = new UrlResource(path.toUri() + audioName);

            if (resource.exists()) {
                return resource;
            } else {
                throw new FileNotFoundException(AUDIO_NOT_EXIST, audioName);
            }
        } catch (MalformedURLException ex) {
            throw new FileNotFoundException(AUDIO_NOT_EXIST, ex);
        }
    }

    AudioDto mapToDto(final Audio audio) {
        return new AudioDto(audio.getDownloadUri());
    }
}

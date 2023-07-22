package engineeringthesis.androidrestapi.audio.domain;

import engineeringthesis.androidrestapi.audio.AudioFacade;
import engineeringthesis.androidrestapi.audio.dto.AudioDto;
import engineeringthesis.androidrestapi.audio.dto.UpdateAudioForm;
import engineeringthesis.androidrestapi.common.entity.ReaderPropertiesFile;
import engineeringthesis.androidrestapi.common.exception.FileNotFoundException;
import engineeringthesis.androidrestapi.common.exception.NotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;
import java.util.UUID;


@RequiredArgsConstructor
class AudioService implements AudioFacade {


    private final AudioRepository audioRepository;
    private final ReaderPropertiesFile readerPropertiesFile;
    private final AudioFileTableRepository audioFileTableRepository;

    @Override
    public List<AudioDto> getAllAudio() {

        return audioRepository.findAll().stream()
                .map(this::mapToDto)
                .toList();
    }

    @Override
    @Transactional
    public AudioDto saveAudio(MultipartFile file) {
        Properties prop;
        try {
            prop = readerPropertiesFile.readPropertiesFile("application.properties");
            Path path = Paths.get(prop.getProperty("audio_save_files_path"));
            //System.out.println(path.resolve(file.getOriginalFilename()));
            Files.write(path.resolve(file.getOriginalFilename()), file.getBytes());

        } catch (Exception e) {
            throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
        }
        AudioFileTable audioId = audioFileTableRepository.findByName(file.getOriginalFilename());
        String streamId = audioId.getStreamId();
        System.out.println(streamId);

        String fileDownloadUri = prop.getProperty("audio_download_uri") + file.getOriginalFilename();

        System.out.println(fileDownloadUri);

        Audio audio = new Audio();
        audio.setAudioFileTable(audioId);
        audio.setDownloadUri(fileDownloadUri);
        audio.setIsAccepted(false);
        audio.setIsNew(true);

        return mapToDto(audioRepository.save(audio));
    }

    @Override
    public AudioDto findAudio(final UUID uuid) {
        return audioRepository.findByUuid(uuid)
                .map(this::mapToDto)
                .orElseThrow(() -> new NotFoundException(""));
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
                .orElseThrow(() -> new NotFoundException(""));
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
            Path path = Paths.get(prop.getProperty("audio_save_files_path"));
            Resource resource = new UrlResource(path.toUri() + audioName);
            System.out.println("Sciezka: " + resource.toString());
            if (resource.exists()) {
                return resource;
            } else {
                throw new FileNotFoundException("File not found " + audioName);
            }
        } catch (MalformedURLException ex) {
            throw new FileNotFoundException("File not found " + audioName, ex);
        }
    }

    AudioDto mapToDto(final Audio audio) {
        return new AudioDto(audio.getDownloadUri());
    }
}

package engineeringthesis.androidrestapi.audio.controller;

import engineeringthesis.androidrestapi.audio.AudioFacade;
import engineeringthesis.androidrestapi.audio.dto.AudioDto;
import engineeringthesis.androidrestapi.audio.dto.AudioFilterForm;
import engineeringthesis.androidrestapi.audio.dto.UpdateAudioForm;
import engineeringthesis.androidrestapi.common.controller.PageDto;
import engineeringthesis.androidrestapi.common.controller.PageableRequest;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

import static engineeringthesis.androidrestapi.audio.controller.AudioController.Routes.ROOT;
import static engineeringthesis.androidrestapi.audio.controller.AudioController.Routes.ROOT_UUID;

@RestController
@RequiredArgsConstructor
class AudioController {

    private final AudioFacade audioFacade;
    private static final Logger logger = LoggerFactory.getLogger(AudioController.class);

    static final class Routes {
        static final String ROOT = "/audios";
        static final String ROOT_UUID = ROOT + "/{uuid}";
    }

    @GetMapping(ROOT)
    PageDto<AudioDto> findAudios(@RequestBody final AudioFilterForm filterForm, final PageableRequest pageableRequest) {
        return audioFacade.findAudios(filterForm, pageableRequest);
    }

    @GetMapping(ROOT_UUID)
    AudioDto findAudio(@PathVariable final UUID uuid) {
        return audioFacade.findAudio(uuid);
    }

    @PostMapping(ROOT)
    @ResponseStatus(HttpStatus.CREATED)
    AudioDto saveAudioFile(@RequestParam("file") final MultipartFile file) {
        return audioFacade.saveAudio(file);
    }

    @PutMapping(ROOT_UUID)
    void updateAudioFile(
            @PathVariable final UUID uuid,
            @RequestBody final UpdateAudioForm audioForm) {
        audioFacade.updateAudio(uuid, audioForm);
    }

    @DeleteMapping(ROOT_UUID)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteAudioFile(@PathVariable final UUID uuid) {
        audioFacade.deleteAudio(uuid);
    }

    @GetMapping("/downloadFile/{fileName:.+}")
    ResponseEntity<Resource> downloadFile(@PathVariable final String fileName, final HttpServletRequest request) {

        // Load file as Resource
        Resource resource = audioFacade.loadAudioAsResource(fileName);

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            logger.info("Could not determine file type.");
        }

        // Fallback to the default content type if type could not be determined
        if (contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
}

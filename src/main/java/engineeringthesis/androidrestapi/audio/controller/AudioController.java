package engineeringthesis.androidrestapi.audio.controller;

import engineeringthesis.androidrestapi.audio.AudioFacade;
import engineeringthesis.androidrestapi.audio.dto.AudioDto;
import engineeringthesis.androidrestapi.audio.dto.UpdateAudioForm;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/audio")
@RequiredArgsConstructor
class AudioController {

    private final AudioFacade audioFacade;
    private static final Logger logger = LoggerFactory.getLogger(AudioController.class);

    @GetMapping
    List<AudioDto> getAllAudioFiles() {
        return audioFacade.getAllAudio();
    }

    @GetMapping(value = "/{uuid}")
    AudioDto getAudio(@PathVariable final UUID uuid) {
        return audioFacade.findAudio(uuid);
    }

    @PostMapping
    AudioDto saveAudioFile(@RequestParam("file") final MultipartFile file) {
        return audioFacade.saveAudio(file);
    }

    @PutMapping(value = "/{uuid}")
    void updateAudioFile(
            @PathVariable final UUID uuid,
            @RequestBody final UpdateAudioForm audioForm) {
        audioFacade.updateAudio(uuid, audioForm);
    }

    @DeleteMapping(value = "/{audioId}")
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

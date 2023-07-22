package engineeringthesis.androidrestapi.image.controller;

import engineeringthesis.androidrestapi.image.ImageFacade;
import engineeringthesis.androidrestapi.image.dto.CreateImageForm;
import engineeringthesis.androidrestapi.image.dto.ImageDto;
import engineeringthesis.androidrestapi.image.dto.UpdateImageForm;
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
@RequestMapping(value = "/api/images")
@RequiredArgsConstructor
class ImageController {

    private final ImageFacade imageFacade;

    private static final Logger logger = LoggerFactory.getLogger(ImageController.class);

    @GetMapping
    List<ImageDto> getAllImages() {
        return imageFacade.getAllImages();
    }

    @GetMapping(value = "/{uuid}")
    ImageDto findImage(@PathVariable final UUID uuid) {
        return imageFacade.findImage(uuid);
    }

    @PostMapping
    ImageDto saveImage(@RequestParam("file") final MultipartFile file) {
        return imageFacade.saveImage(file);
    }

    @PutMapping(value = "/{uuid}")
    void updateImage(@PathVariable final UUID uuid, @RequestBody final UpdateImageForm imageForm) {
        imageFacade.updateImage(uuid, imageForm);
    }

    @DeleteMapping(value = "/{uuid}")
    void deleteImage(@PathVariable final UUID uuid) {
        imageFacade.deleteImage(uuid);
    }

    @GetMapping("/downloadFile/{fileName:.+}")
    ResponseEntity<Resource> downloadFile(@PathVariable final String fileName, final HttpServletRequest request) {
        // Load file as Resource
        Resource resource = imageFacade.loadImageAsResource(fileName);

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

        return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
}

package engineeringthesis.androidrestapi.image;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api/images")
@RequiredArgsConstructor
class ImageController {

	private final ImageServiceImpl imageServiceImpl;

	private static final Logger logger = LoggerFactory.getLogger(ImageController.class);

	@GetMapping
	List<ImageDTO> getAllImages() {
		return imageServiceImpl.getAllImages();
	}

	@GetMapping(value = "/{imageId}")
	ImageDTO getImageById(@PathVariable Integer imageId) {
		return imageServiceImpl.getOneById(imageId);
	}

	@PostMapping
	ImageDTO saveImage(@RequestParam("file") MultipartFile file) {
		return imageServiceImpl.saveImage(file);
	}

	@PutMapping(value = "/{imageId}")
	ImageDTO updateImage(@RequestBody ImageDTO imageObj, @PathVariable Integer imageId) {
		return imageServiceImpl.updateImage(imageId, imageObj);
	}

	@DeleteMapping(value = "/{imageId}")
	void deleteImage(@PathVariable Integer imageId) {
		imageServiceImpl.deleteImage(imageId);
	}

	@GetMapping("/downloadFile/{fileName:.+}")
	ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
		// Load file as Resource
		Resource resource = imageServiceImpl.loadImageAsResource(fileName);

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

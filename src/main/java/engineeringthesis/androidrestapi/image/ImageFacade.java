package engineeringthesis.androidrestapi.image;

import java.util.List;
import java.util.UUID;

import engineeringthesis.androidrestapi.image.dto.CreateImageForm;
import engineeringthesis.androidrestapi.image.dto.ImageDto;
import engineeringthesis.androidrestapi.image.dto.UpdateImageForm;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface ImageFacade {
	

	List<ImageDto> getAllImages();
	
	ImageDto saveImage(final MultipartFile file);

	ImageDto findImage(final UUID uuid);
	
	void updateImage(final UUID uuid, final UpdateImageForm imageForm);
	
	Resource loadImageAsResource(final String imageName);
	
	void deleteImage(final UUID uuid);
}

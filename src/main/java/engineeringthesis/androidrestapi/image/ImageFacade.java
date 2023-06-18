package engineeringthesis.androidrestapi.image;

import java.util.List;

import engineeringthesis.androidrestapi.image.dto.ImageDTO;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface ImageFacade {
	

	List<ImageDTO> getAllImages();
	
	ImageDTO saveImage(MultipartFile file);
	
	ImageDTO getOneByName(String name);
	
	ImageDTO getOneById(Integer imageId);
	
	ImageDTO updateImage(Integer imageId,ImageDTO imageObj);
	
	Resource loadImageAsResource(String imageName);
	
	void deleteImage(Integer imageId);
}

package engineeringthesis.androidrestapi.service;

import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import engineeringthesis.androidrestapi.dto.ImageDTO;

public interface ImageService {
	

	List<ImageDTO> getAllImages();
	
	ImageDTO saveImage(MultipartFile file);
	
	ImageDTO getOneByName(String name);
	
	ImageDTO getOneById(Integer imageId);
	
	ImageDTO updateImage(Integer imageId,ImageDTO imageObj);
	
	Resource loadImageAsResource(String imageName);
	
	void deleteImage(Integer imageId);
}

package engineeringthesis.androidrestapi.service;

import java.util.List;
import java.util.Optional;

import engineeringthesis.androidrestapi.model.image;

public interface imageService {
	

	List<image> getAllImages();
	
	image saveImages(image children);
	
	image getOneByName(String name);
	
	Optional<image> getOneById(Integer imageId);
	
	void deleteImage(Integer imageId);
}

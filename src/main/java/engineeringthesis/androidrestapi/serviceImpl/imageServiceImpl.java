package engineeringthesis.androidrestapi.serviceImpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import engineeringthesis.androidrestapi.model.image;
import engineeringthesis.androidrestapi.repository.imageRepository;
import engineeringthesis.androidrestapi.service.imageService;

@Service
@Transactional
public class imageServiceImpl implements imageService {

	@Autowired
	imageRepository imageReposiitory;

	@Override
	public List<image> getAllImages() {
		return imageReposiitory.findAll();
	}

	@Override
	public image saveImages(image imageObj) {
		return imageReposiitory.save(imageObj);
	}

	@Override
	public image getOneByName(String name) {
		return null;
	}

	@Override
	public Optional<image> getOneById(Integer imageId) {
		return imageReposiitory.findById(imageId);
	}

	@Override
	public void deleteImage(Integer imageId) {
		imageReposiitory.deleteById(imageId);
		
	}
	
}

package engineeringthesis.androidrestapi.image.domain;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.Properties;


import engineeringthesis.androidrestapi.common.exception.FileNotFoundException;
import engineeringthesis.androidrestapi.image.ImageFacade;
import engineeringthesis.androidrestapi.image.dto.ImageDTO;
import jakarta.transaction.Transactional;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import engineeringthesis.androidrestapi.common.entity.ReaderPropertiesFile;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class ImageService implements ImageFacade {

	private final ImageRepository imageReposiitory;
	private final ImageMapper imageMapper;
	private final ReaderPropertiesFile readerPropertiesFile;
	private final ImageFileTableRepository imageFileTableRepository;

	@Override
	public List<ImageDTO> getAllImages() {
		return imageMapper.mapOfCollection(imageReposiitory.findAll());
	}

	@Override
	public ImageDTO saveImage(MultipartFile file) {
		Properties prop;
		try {
			 prop  = readerPropertiesFile.readPropertiesFile("application.properties");
			Path path = Paths.get(prop.getProperty("image_save_files_path"));
			//System.out.println(path.resolve(file.getOriginalFilename()));
			Files.write(path.resolve(file.getOriginalFilename()),file.getBytes());
		
		  }  catch (Exception e) {
		      throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
		    }
		 	ImageFileTable imgId = imageFileTableRepository.findByName(file.getOriginalFilename());
		 	String streamId = imgId.getStreamId();
		 	System.out.println(streamId);
		 	
		 	String fileDownloadUri = prop.getProperty("image_download_uri")+file.getOriginalFilename();
		 	System.out.println(fileDownloadUri);
		 	
		 	//WordEntity word = wordRepository.findById(wordid);
		 
			ImageDTO imageObj = new ImageDTO(); 
			imageObj.setImageFileTable(imgId);
			imageObj.setImageDownloadUri(fileDownloadUri);
			imageObj.setAccepted(false);
			imageObj.setNew(true);
			Image imageEntity = imageMapper.mapOfDTO(imageObj);
			Image savedEntity = imageReposiitory.save(imageEntity);
			
		return imageMapper.mapOfEntity(savedEntity);
		
		
	}

	
	@Override
	public ImageDTO getOneByName(String name) {
		return null;
	}

	@Override
	public ImageDTO getOneById(Integer imageId) {
		return imageMapper.mapOfEntity(imageReposiitory.findById(imageId).get());
	}
	
	@Override
	public ImageDTO updateImage(Integer imageId, ImageDTO imageObj) {
		
		Optional<Image> imageEntity = imageReposiitory.findById(imageId);
		Image savedEntity = imageEntity.get();
		imageReposiitory.save(savedEntity);
		ImageDTO dto = imageMapper.mapOfEntity(savedEntity);
		return dto;
	}

	@Override
	public void deleteImage(Integer imageId) {
		
		imageReposiitory.deleteById(imageId);
	}

	@Override
	public Resource loadImageAsResource(String  imageName) {
		
		try {
			Properties prop = null;
			try {
				prop = readerPropertiesFile.readPropertiesFile("application.properties");
			} catch (IOException e) {
				e.printStackTrace();
			}
			Path path = Paths.get(prop.getProperty("image_save_files_path"));
            Resource resource = new UrlResource(path.toUri() + imageName);
            if(resource.exists()) {
                return resource;
            } else {
                throw new FileNotFoundException("File not found " + imageName);
            }
        } catch (MalformedURLException ex) {
            throw new FileNotFoundException("File not found " + imageName, ex);
        }
	}

	
	
}

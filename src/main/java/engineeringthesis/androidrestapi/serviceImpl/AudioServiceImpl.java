    package engineeringthesis.androidrestapi.serviceImpl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import javax.transaction.Transactional;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import engineeringthesis.androidrestapi.config.ReaderPropertiesFile;
import engineeringthesis.androidrestapi.dto.AudioDTO;
import engineeringthesis.androidrestapi.entity.AudioEntity;
import engineeringthesis.androidrestapi.entity.AudioFileTableEntity;
import engineeringthesis.androidrestapi.exception.MyFileNotFoundException;
import engineeringthesis.androidrestapi.mapper.AudioMapper;
import engineeringthesis.androidrestapi.repository.AudioFileTableRepository;
import engineeringthesis.androidrestapi.repository.AudioRepository;
import engineeringthesis.androidrestapi.service.AudioService;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class AudioServiceImpl implements AudioService {

	
	private final AudioRepository audioRepository;
	private final AudioMapper audioMapper;
	private final ReaderPropertiesFile readerPropertiesFile;
	private final AudioFileTableRepository audioFileTableRepository;
	
	@Override
	public List<AudioDTO> getAllAudio() {
		
		return audioMapper.mapOfCollection(audioRepository.findAll());
	}

	@Override
	public AudioDTO saveAudio(MultipartFile file) {
		Properties prop;
		try {
				prop  = readerPropertiesFile.readPropertiesFile("application.properties");
				Path path = Paths.get(prop.getProperty("audio_save_files_path"));
				//System.out.println(path.resolve(file.getOriginalFilename()));
				Files.write(path.resolve(file.getOriginalFilename()),file.getBytes());
			
			  }  catch (Exception e) {
			      throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
			    }
			AudioFileTableEntity audioId = audioFileTableRepository.findByName(file.getOriginalFilename());
			 	String streamId = audioId.getStreamId();
			 	System.out.println(streamId);
			 	
			 	String fileDownloadUri = prop.getProperty("audio_download_uri")+file.getOriginalFilename();
		              
			 	System.out.println(fileDownloadUri);
		
				AudioDTO audio = new AudioDTO();
				audio.setAudioFileTableEntity(audioId);
				audio.setAudioDownloadUri(fileDownloadUri);
				audio.setAccepted(false);
				audio.setNew(true);
				AudioEntity languageEntity = audioMapper.mapOfDTO(audio);
				AudioEntity savedEntity = audioRepository.save(languageEntity);
				 return audioMapper.mapOfEntity(savedEntity);
	}

	@Override
	public AudioDTO getOneByName(String name) {
		
		return audioMapper.mapOfEntity(audioRepository.findByName(name));
	}

	@Override
	public AudioDTO getOneById(Integer audioId) {
		
		return audioMapper.mapOfEntity(audioRepository.findById(audioId).get());
	}

	@Override
	public void deleteAudio(Integer audioId) {
		
		audioRepository.deleteById(audioId);
	}

	@Override
	public AudioDTO updateAudio(Integer audioId, AudioDTO audio) {
		
		Optional<AudioEntity> audioEntity = audioRepository.findById(audioId);
		AudioEntity savedEntity = audioEntity.get();
		audioRepository.save(savedEntity);
		AudioDTO dto = audioMapper.mapOfEntity(savedEntity);
		return dto;
	}
	
	@Override
	public Resource loadAudioAsResource(String  audioName) {
		
		try {
			Properties prop = null;
			try {
				prop = readerPropertiesFile.readPropertiesFile("application.properties");
			} catch (IOException e) {
				e.printStackTrace();
			}
			Path path = Paths.get(prop.getProperty("audio_save_files_path"));
            Resource resource = new UrlResource(path.toUri() + audioName);
            System.out.println("Sciezka: " + resource.toString());
            if(resource.exists()) {
                return resource;
            } else {
                throw new MyFileNotFoundException("File not found " + audioName);
            }
        } catch (MalformedURLException ex) {
            throw new MyFileNotFoundException("File not found " + audioName, ex);
        }
	}
}

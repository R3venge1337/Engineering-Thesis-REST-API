    package engineeringthesis.androidrestapi.serviceImpl;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import engineeringthesis.androidrestapi.config.ReaderPropertiesFile;
import engineeringthesis.androidrestapi.dto.AudioDTO;
import engineeringthesis.androidrestapi.entity.AudioEntity;
import engineeringthesis.androidrestapi.entity.AudioFileTableEntity;
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
		 try {
				Properties prop  = readerPropertiesFile.readPropertiesFile("application.properties");
				Path path = Paths.get(prop.getProperty("audio_save_files_path"));
				//System.out.println(path.resolve(file.getOriginalFilename()));
				Files.write(path.resolve(file.getOriginalFilename()),file.getBytes());
			
			  }  catch (Exception e) {
			      throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
			    }
			AudioFileTableEntity imgId = audioFileTableRepository.findByName(file.getOriginalFilename());
			 	String streamId = imgId.getStreamId();
			 	System.out.println(streamId);
			 	
			 	String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
		                .path("/api")
		                .path("/audios/")
		                .path(file.getOriginalFilename())
		                .toUriString();
			 	System.out.println(fileDownloadUri);
		
		/*
		AudioEntity languageEntity = audioMapper.mapOfDTO(audio);
		AudioEntity savedEntity = audioRepository.save(languageEntity);
		 return audioMapper.mapOfEntity(savedEntity);
		 */
			 	return null;
	}

	@Override
	public AudioDTO getOneByName(String name) {
		
		return null;
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
	
}

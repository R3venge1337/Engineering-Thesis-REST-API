    package engineeringthesis.androidrestapi.audio.domain;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.Properties;


import engineeringthesis.androidrestapi.audio.AudioFacade;
import engineeringthesis.androidrestapi.audio.dto.AudioDTO;
import engineeringthesis.androidrestapi.common.exception.FileNotFoundException;
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
class AudioService implements AudioFacade {

	
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
			AudioFileTable audioId = audioFileTableRepository.findByName(file.getOriginalFilename());
			 	String streamId = audioId.getStreamId();
			 	System.out.println(streamId);
			 	
			 	String fileDownloadUri = prop.getProperty("audio_download_uri")+file.getOriginalFilename();
		              
			 	System.out.println(fileDownloadUri);
		
				AudioDTO audio = new AudioDTO();
				audio.setAudioFileTable(audioId);
				audio.setAudioDownloadUri(fileDownloadUri);
				audio.setAccepted(false);
				audio.setNew(true);
				Audio languageEntity = audioMapper.mapOfDTO(audio);
				Audio savedEntity = audioRepository.save(languageEntity);
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
		
		Optional<Audio> audioEntity = audioRepository.findById(audioId);
		Audio savedEntity = audioEntity.get();
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
                throw new FileNotFoundException("File not found " + audioName);
            }
        } catch (MalformedURLException ex) {
            throw new FileNotFoundException("File not found " + audioName, ex);
        }
	}
}

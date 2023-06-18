package engineeringthesis.androidrestapi.audio;

import java.util.List;

import engineeringthesis.androidrestapi.audio.dto.AudioDTO;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;


public interface AudioFacade {
	
	List<AudioDTO> getAllAudio();
	
	AudioDTO saveAudio(MultipartFile file);
	
	AudioDTO getOneByName(String name);
	
	AudioDTO getOneById(Integer audioId);
	
	AudioDTO updateAudio(Integer audioId, AudioDTO audio);
	
	void deleteAudio(Integer audioId);
	
	Resource loadAudioAsResource(String audioName);
}

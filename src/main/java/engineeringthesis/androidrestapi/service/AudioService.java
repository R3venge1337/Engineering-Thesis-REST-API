package engineeringthesis.androidrestapi.service;

import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import engineeringthesis.androidrestapi.dto.AudioDTO;


public interface AudioService {
	
	List<AudioDTO> getAllAudio();
	
	AudioDTO saveAudio(MultipartFile file);
	
	AudioDTO getOneByName(String name);
	
	AudioDTO getOneById(Integer audioId);
	
	AudioDTO updateAudio(Integer audioId, AudioDTO audio);
	
	void deleteAudio(Integer audioId);
	
	Resource loadAudioAsResource(String audioName);
}

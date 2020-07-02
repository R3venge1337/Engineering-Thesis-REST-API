package engineeringthesis.androidrestapi.service;

import java.util.List;
import java.util.Optional;

import engineeringthesis.androidrestapi.model.audio;



public interface audioService {
	
	List<audio> getAllAudio();
	
	audio saveAudio(audio ad);
	
	audio getOneByName(String name);
	
	Optional<audio> getOneById(Integer audioId);
	
	void deleteAudio(Integer audioId);
}

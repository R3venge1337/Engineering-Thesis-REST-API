package engineeringthesis.androidrestapi.audio;

import java.util.List;
import java.util.UUID;

import engineeringthesis.androidrestapi.audio.dto.AudioDto;
import engineeringthesis.androidrestapi.audio.dto.UpdateAudioForm;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;


public interface AudioFacade {
	
	List<AudioDto> getAllAudio();
	
	AudioDto saveAudio(final MultipartFile file);

	AudioDto findAudio(final UUID uuid);

	void updateAudio(final UUID uuid, final UpdateAudioForm audioForm);
	
	void deleteAudio(final UUID uuid);
	
	Resource loadAudioAsResource(final String audioName);
}

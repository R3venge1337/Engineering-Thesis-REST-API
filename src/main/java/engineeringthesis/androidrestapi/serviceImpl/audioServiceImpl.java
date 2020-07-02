    package engineeringthesis.androidrestapi.serviceImpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import engineeringthesis.androidrestapi.model.audio;
import engineeringthesis.androidrestapi.repository.audioRepository;
import engineeringthesis.androidrestapi.service.audioService;

@Service
@Transactional
public class audioServiceImpl implements audioService {

	@Autowired
	audioRepository audioRepository;
	
	
	@Override
	public List<audio> getAllAudio() {
		return audioRepository.findAll();
	}

	@Override
	public audio saveAudio(audio audioFile) {
		return audioRepository.save(audioFile);
	}

	@Override
	public audio getOneByName(String name) {
		return null;
	}

	@Override
	public Optional<audio> getOneById(Integer audioId) {
		return audioRepository.findById(audioId);
	}

	@Override
	public void deleteAudio(Integer audioId) {
		audioRepository.deleteById(audioId);
		
	}
	
}

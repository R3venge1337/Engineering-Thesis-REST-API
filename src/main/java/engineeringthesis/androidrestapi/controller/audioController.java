package engineeringthesis.androidrestapi.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import engineeringthesis.androidrestapi.dto.AudioDTO;
import engineeringthesis.androidrestapi.serviceImpl.AudioServiceImpl;

@RestController
@RequestMapping(value = "/api/audio")
public class AudioController {

	@Autowired
    private AudioServiceImpl audioServiceImpl;
	
	@GetMapping
    List<AudioDTO> getAllAudioFiles()
    {
		return audioServiceImpl.getAllAudio();
    }
    
    @GetMapping(value = "/{audioFileName}")
    AudioDTO getAudioFileByName(@PathVariable String audioFileName )
    {
		return audioServiceImpl.getOneByName(audioFileName);
    }
    
    @GetMapping(value = "/{audioId}")
    AudioDTO getAudioById(@PathVariable Integer audioId )
    {
		return audioServiceImpl.getOneById(audioId);
    }
    
    @PostMapping
    AudioDTO saveAudioFile(@RequestParam("file") MultipartFile file)
    {
    	return audioServiceImpl.saveAudio(file);
    }
    
    @PutMapping(value = "/{audioId}" )
    AudioDTO updateAudioFile(@RequestBody AudioDTO audioFileObj,
    						@PathVariable Integer audioId)
    {
    	return audioServiceImpl.updateAudio(audioId,audioFileObj);
    }
    
    @DeleteMapping(value = "/{audioId}")
    void deleteAudioFile(@PathVariable Integer audioId)
    {
    	audioServiceImpl.deleteAudio(audioId);
    }
    
    
	
	
}

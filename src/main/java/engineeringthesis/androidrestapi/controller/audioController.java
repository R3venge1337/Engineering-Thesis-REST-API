package engineeringthesis.androidrestapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import engineeringthesis.androidrestapi.model.audio;
import engineeringthesis.androidrestapi.serviceImpl.audioServiceImpl;

@RestController
public class audioController {

	@Autowired
    private audioServiceImpl audioServiceImpl;
	
	 //@GetMapping
    @RequestMapping(value="/audio",method = RequestMethod.GET)
    List<audio> getAllAudioFiles()
    {
		return audioServiceImpl.getAllAudio();
    }
    
    //@GetMapping
    @RequestMapping(value="/audio/{audioFileName}",method = RequestMethod.GET)
    audio getAudioFileByName(@PathVariable String audioFileName )
    {
		return audioServiceImpl.getOneByName(audioFileName);
    }
    
   // @GetMapping
    @RequestMapping(value="/audio/{audioId}",method = RequestMethod.GET)
    Optional<audio> getAudioById(@PathVariable Integer audioId )
    {
		return audioServiceImpl.getOneById(audioId);
    }
    
    // @PostMapping
    @RequestMapping(value="/audio",method =  RequestMethod.POST)
    audio saveAudioFile(@ModelAttribute audio audioFileObj)
    {
    	return audioServiceImpl.saveAudio(audioFileObj);
    }
    //@PutMapping
    @RequestMapping(value="/audio",method = RequestMethod.PUT)
    audio updateAudioFile(@ModelAttribute audio audioFileObj)
    {
    	return audioServiceImpl.saveAudio(audioFileObj);
    }
    //@DeleteMapping
    @RequestMapping(value="/audio/{audioId}",method= RequestMethod.DELETE)
    void deleteAudioFile(@PathVariable Integer audioId)
    {
    	audioServiceImpl.deleteAudio(audioId);
    }
    
    
	
	
}

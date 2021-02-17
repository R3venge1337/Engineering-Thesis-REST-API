package engineeringthesis.androidrestapi.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import engineeringthesis.androidrestapi.dto.AudioDTO;
import engineeringthesis.androidrestapi.serviceImpl.AudioServiceImpl;

@RestController
@RequestMapping(value = "/api/audio")
public class AudioController {

	@Autowired
    private AudioServiceImpl audioServiceImpl;
	private static final Logger logger = LoggerFactory.getLogger(AudioController.class);

	@GetMapping
    List<AudioDTO> getAllAudioFiles()
    {
		return audioServiceImpl.getAllAudio();
    }
    
    @GetMapping(params="audioFileName")
    AudioDTO getAudioFileByName(@RequestParam("audioFileName") String audioFileName )
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
    
    @GetMapping("/downloadFile/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        
    	// Load file as Resource
        Resource resource = audioServiceImpl.loadAudioAsResource(fileName);

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            logger.info("Could not determine file type.");
        }

        // Fallback to the default content type if type could not be determined
        if(contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
    
    
	
	
}

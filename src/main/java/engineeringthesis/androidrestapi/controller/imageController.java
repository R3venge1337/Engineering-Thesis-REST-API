package engineeringthesis.androidrestapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import engineeringthesis.androidrestapi.model.image;
import engineeringthesis.androidrestapi.serviceImpl.imageServiceImpl;

@RestController
public class imageController {
	
	@Autowired
    private imageServiceImpl imageServiceImpl;
	
	//@GetMapping
    @RequestMapping(value="/images",method = RequestMethod.GET)
    List<image> getAllImages()
    {
		return imageServiceImpl.getAllImages();
    }
    
   // @GetMapping
    @RequestMapping(value="/image/{imageId}",method = RequestMethod.GET)
    Optional<image> getImageById(@PathVariable Integer imageId )
    {
		return imageServiceImpl.getOneById(imageId);
    }
    
   // @PostMapping
    @RequestMapping(value="/image",method =  RequestMethod.POST)
    image saveImage(@ModelAttribute image imageObj)
    {
    	return imageServiceImpl.saveImages(imageObj);
    }
    //@PutMapping
    @RequestMapping(value="/image",method = RequestMethod.PUT)
    image updateImage(@ModelAttribute image imageObj)
    {
    	return imageServiceImpl.saveImages(imageObj);
    }
    //@DeleteMapping
    @RequestMapping(value="/image/{imageId}",method= RequestMethod.DELETE)
    void deleteImage(@PathVariable Integer imageId)
    {
    	imageServiceImpl.deleteImage(imageId);
    }
}

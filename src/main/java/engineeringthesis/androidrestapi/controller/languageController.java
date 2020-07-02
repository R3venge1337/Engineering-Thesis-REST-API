package engineeringthesis.androidrestapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import engineeringthesis.androidrestapi.model.language;
import engineeringthesis.androidrestapi.serviceImpl.languageServiceImpl;

@RestController
public class languageController {

	 @Autowired
	    private languageServiceImpl languageService;
	 
	 
	    //@GetMapping
	    @RequestMapping(value="/languages",method = RequestMethod.GET)
	    List<language> getAllLanguages()
	    {
			return languageService.getAllLanguage();
	    }
	    
	    //@GetMapping
	    @RequestMapping(value="/language/{languageName}",method = RequestMethod.GET)
	    language getLanguageByName(@PathVariable String languageName )
	    {
			return languageService.getOneByName(languageName);
	    }
	    
	   // @GetMapping
	    @RequestMapping(value="/language/{id}",method = RequestMethod.GET)
	    Optional<language> getLanguageById(@PathVariable Integer id )
	    {
			return languageService.getOneById(id);
	    }
	    
	   // @PostMapping
	    @RequestMapping(value="/language",method =  RequestMethod.POST)
	    language saveLanguage(@ModelAttribute language lang)
	    {
	    	return languageService.saveLanguage(lang);
	    }
	    //@PutMapping
	    @RequestMapping(value="/language",method = RequestMethod.PUT)
	    language updateLanguage(@ModelAttribute language lang)
	    {
	    	return languageService.saveLanguage(lang);
	    }
	    //@DeleteMapping
	    @RequestMapping(value="/language/{id}",method= RequestMethod.DELETE)
	    void deleteLanguage(@PathVariable Integer id)
	    {
	    	languageService.deleteLanguage(id);
	    }
}

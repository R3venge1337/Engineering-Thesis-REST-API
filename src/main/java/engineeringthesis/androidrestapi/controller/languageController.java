package engineeringthesis.androidrestapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import engineeringthesis.androidrestapi.dto.LanguageDTO;
import engineeringthesis.androidrestapi.serviceImpl.LanguageServiceImpl;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/languages")
public  class LanguageController {

	    private final LanguageServiceImpl languageService;
	    
	    @GetMapping
	    List<LanguageDTO> getAllLanguages()
	    {
			return languageService.getAllLanguage();
	    }
	    
	    
	   @GetMapping(value = "/{languageId}")
	   LanguageDTO getLanguageById(@PathVariable Integer languageId)
	    {
			return languageService.getOneById(languageId);
	    }
	    
	    @PostMapping
	    LanguageDTO saveLanguage(@RequestBody  LanguageDTO lang)
	    {
	    	return languageService.saveLanguage(lang);
	    }
	    
	    @PutMapping(value = "/{languageId}")
	    void updateLanguage(@RequestBody LanguageDTO lang, 
	    					@PathVariable Integer languageId)
	    {
	    	languageService.updateLanguage(languageId, lang);
	    }
	    
	   @DeleteMapping(value = "/{languageId}")
	    void deleteLanguage(@PathVariable Integer languageId)
	    {
	    	languageService.deleteLanguage(languageId);
	    }
}

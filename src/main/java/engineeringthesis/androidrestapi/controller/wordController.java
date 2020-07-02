package engineeringthesis.androidrestapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import engineeringthesis.androidrestapi.model.word;
import engineeringthesis.androidrestapi.serviceImpl.wordServiceImpl;

@RestController
public class wordController {

		@Autowired
		wordServiceImpl wordServiceImpl;
		
		  //@GetMapping
	    @RequestMapping(value = {"/words"}, method = RequestMethod.GET)
	    List<word> getAllWords()
	    {
			return wordServiceImpl.getAllWords();
	    }
	    
	    //@GetMapping
	    @RequestMapping(value="/word/{wordId}",method = RequestMethod.GET)
	    Optional<word> getWordById(@PathVariable Integer wordId )
	    {
			return wordServiceImpl.getOneById(wordId);
	    }
	    //@PostMapping
	    @RequestMapping(value="/word",method = RequestMethod.POST)
	    word saveWord(@ModelAttribute word wordObj)
	    {
	    	return wordServiceImpl.saveWord(wordObj);
	    }
	    @PutMapping
	    @RequestMapping(value="/word",method = RequestMethod.PUT)
	    word updateWord(@ModelAttribute word wordObj)
	    {
	    	return wordServiceImpl.saveWord(wordObj);
	    }
	    @DeleteMapping
	    @RequestMapping(value="/word/{wordId}",method= RequestMethod.DELETE)
	    void deleteWordById(@PathVariable Integer wordId)
	    {
	    	wordServiceImpl.deleteWord(wordId);
	    }
		
}

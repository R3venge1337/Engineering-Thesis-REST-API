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
import org.springframework.web.bind.annotation.RestController;

import engineeringthesis.androidrestapi.dto.WordDTO;
import engineeringthesis.androidrestapi.serviceImpl.WordServiceImpl;

@RestController
@RequestMapping(value="/api/words")
public class WordController {

		@Autowired
		WordServiceImpl wordServiceImpl;
		
		@GetMapping
	    List<WordDTO> getAllWords()
	    {
			return wordServiceImpl.getAllWords();
	    }
	    
	    @GetMapping(value = "/{wordId}")
	    WordDTO getWordById(@PathVariable Integer wordId )
	    {
			return wordServiceImpl.getOneById(wordId);
	    }
	    
	    @PostMapping
	    WordDTO saveWord(@RequestBody WordDTO wordObj)
	    {
	    	return wordServiceImpl.saveWord(wordObj);
	    }
	    
	    @PutMapping(value = "/{wordId}")
	    WordDTO updateWord(@RequestBody WordDTO wordObj,
	    				@PathVariable Integer wordId)
	    {
	    	return wordServiceImpl.updateWord(wordId,wordObj);
	    }
	    
	    @DeleteMapping(value = "/{wordId}")
	    void deleteWordById(@PathVariable Integer wordId)
	    {
	    	wordServiceImpl.deleteWord(wordId);
	    }
		
}

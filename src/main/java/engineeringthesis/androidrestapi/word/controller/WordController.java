package engineeringthesis.androidrestapi.word.controller;

import java.util.List;

import engineeringthesis.androidrestapi.word.WordFacade;
import engineeringthesis.androidrestapi.word.dto.WordDTO;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api/words")
@RequiredArgsConstructor
class WordController {

	private final WordFacade wordServiceImpl;

	@GetMapping
	List<WordDTO> getAllWords() {
		return wordServiceImpl.getAllWords();
	}

	@GetMapping(value = "/{wordId}")
	WordDTO getWordById(@PathVariable Integer wordId) {
		return wordServiceImpl.getWordById(wordId);
	}

	@GetMapping(params = "wordName")
	WordDTO getWordByName(@RequestParam(value = "wordName", required = false) String wordName) {
		return wordServiceImpl.getWordByName(wordName);
	}

	@PostMapping
	WordDTO saveWord(@RequestBody WordDTO wordObj) {
		return wordServiceImpl.saveWord(wordObj);
	}

	@PutMapping(value = "/{wordId}")
	WordDTO updateWord(@PathVariable Integer wordId, @RequestBody WordDTO wordObj) {
		return wordServiceImpl.updateWord(wordId, wordObj);
	}

	@DeleteMapping(value = "/{wordId}")
	void deleteWordById(@PathVariable Integer wordId) {
		wordServiceImpl.deleteWord(wordId);
	}

	@GetMapping(value = "/categories")
	List<WordDTO> getAllWordsFromCategory(@RequestParam("categoryName") String categoryName,
			@RequestParam("pageNumber") Integer pageNumber, @RequestParam("size") Integer size)

	{
		return wordServiceImpl.getWordsByCategoryName(categoryName, pageNumber, size).toList();
	}

}

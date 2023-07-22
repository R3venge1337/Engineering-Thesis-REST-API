package engineeringthesis.androidrestapi.word.controller;

import engineeringthesis.androidrestapi.word.WordFacade;
import engineeringthesis.androidrestapi.word.dto.CreateWordForm;
import engineeringthesis.androidrestapi.word.dto.UpdateWordForm;
import engineeringthesis.androidrestapi.word.dto.WordDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/words")
@RequiredArgsConstructor
class WordController {

    private final WordFacade wordServiceImpl;

    @GetMapping
    List<WordDto> getAllWords() {
        return wordServiceImpl.getAllWords();
    }

    @GetMapping(params = "name")
    WordDto getWordByName(@RequestParam(required = false) final String name) {
        return wordServiceImpl.getWordByName(name);
    }

    @PostMapping
    WordDto saveWord(@RequestBody final CreateWordForm wordForm) {
        return wordServiceImpl.saveWord(wordForm);
    }

    @PutMapping(value = "/{uuid}")
    WordDto updateWord(@PathVariable final UUID uuid, @RequestBody final UpdateWordForm wordForm) {
        return wordServiceImpl.updateWord(uuid, wordForm);
    }

    @DeleteMapping(value = "/{uuid}")
    void deleteWordById(@PathVariable final UUID uuid) {
        wordServiceImpl.deleteWord(uuid);
    }

    @GetMapping(value = "/categories")
    List<WordDto> getAllWordsFromCategory(@RequestParam("categoryName") final String categoryName,
                                          @RequestParam("pageNumber") final Integer pageNumber, @RequestParam("size") final Integer size) {
        return wordServiceImpl.getWordsByCategoryName(categoryName, pageNumber, size).toList();
    }

}

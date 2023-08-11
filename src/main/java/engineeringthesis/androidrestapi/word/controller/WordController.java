package engineeringthesis.androidrestapi.word.controller;

import engineeringthesis.androidrestapi.common.controller.PageDto;
import engineeringthesis.androidrestapi.common.controller.PageableRequest;
import engineeringthesis.androidrestapi.common.controller.UuidDto;
import engineeringthesis.androidrestapi.word.WordFacade;
import engineeringthesis.androidrestapi.word.dto.CreateWordForm;
import engineeringthesis.androidrestapi.word.dto.UpdateWordForm;
import engineeringthesis.androidrestapi.word.dto.WordDto;
import engineeringthesis.androidrestapi.word.dto.WordFilterForm;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static engineeringthesis.androidrestapi.word.controller.WordController.Routes.ROOT;
import static engineeringthesis.androidrestapi.word.controller.WordController.Routes.ROOT_CATEGORIES;
import static engineeringthesis.androidrestapi.word.controller.WordController.Routes.ROOT_UUID;

@RestController
@RequiredArgsConstructor
class WordController {

    private final WordFacade wordServiceImpl;

    static final class Routes {
        static final String ROOT = "/words";
        static final String ROOT_UUID = ROOT + "/{uuid}";

        static final String ROOT_CATEGORIES = ROOT + "/categories";
    }

    @GetMapping(ROOT)
    PageDto<WordDto> findWords(@RequestBody final WordFilterForm filterForm, final PageableRequest pageableRequest) {
        return wordServiceImpl.findWords(filterForm, pageableRequest);
    }

    @PostMapping(ROOT)
    @ResponseStatus(HttpStatus.CREATED)
    UuidDto saveWord(@RequestBody final CreateWordForm wordForm) {
        return wordServiceImpl.saveWord(wordForm);
    }

    @PutMapping(ROOT_UUID)
    void updateWord(@PathVariable final UUID uuid, @RequestBody final UpdateWordForm wordForm) {
        wordServiceImpl.updateWord(uuid, wordForm);
    }

    @DeleteMapping(ROOT_UUID)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteWord(@PathVariable final UUID uuid) {
        wordServiceImpl.deleteWord(uuid);
    }

    @GetMapping(ROOT_CATEGORIES)
    PageDto<WordDto> getAllWordsFromCategory(@RequestParam final String categoryName, @RequestParam final PageableRequest pageableRequest) {
        return wordServiceImpl.getWordsByCategoryName(categoryName, pageableRequest);
    }

}

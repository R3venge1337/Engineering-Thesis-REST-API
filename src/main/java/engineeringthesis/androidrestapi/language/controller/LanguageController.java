package engineeringthesis.androidrestapi.language.controller;

import engineeringthesis.androidrestapi.language.LanguageFacade;
import engineeringthesis.androidrestapi.language.dto.CreateLanguageForm;
import engineeringthesis.androidrestapi.language.dto.LanguageDto;
import engineeringthesis.androidrestapi.language.dto.UpdateLanguageForm;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/languages")
@RequiredArgsConstructor
class LanguageController {

    private final LanguageFacade languageFacade;

    @GetMapping
    List<LanguageDto> getAllLanguages() {
        return languageFacade.getAllLanguage();
    }

    @GetMapping(value = "/{uuid}")
    LanguageDto findLanguage(@PathVariable final UUID uuid) {
        return languageFacade.findLanguage(uuid);
    }

    @PostMapping
    LanguageDto saveLanguage(@RequestBody final CreateLanguageForm languageForm) {
        return languageFacade.saveLanguage(languageForm);
    }

    @PutMapping(value = "/{languageId}")
    void updateLanguage(@PathVariable final UUID uuid, @RequestBody final UpdateLanguageForm languageForm) {
        languageFacade.updateLanguage(uuid, languageForm);
    }

    @DeleteMapping(value = "/{uuid}")
    void deleteLanguage(@PathVariable final UUID uuid) {
        languageFacade.deleteLanguage(uuid);
    }
}

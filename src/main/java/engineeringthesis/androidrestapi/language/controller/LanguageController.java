package engineeringthesis.androidrestapi.language.controller;

import engineeringthesis.androidrestapi.common.controller.PageDto;
import engineeringthesis.androidrestapi.common.controller.PageableRequest;
import engineeringthesis.androidrestapi.common.controller.UuidDto;
import engineeringthesis.androidrestapi.language.LanguageFacade;
import engineeringthesis.androidrestapi.language.dto.CreateLanguageForm;
import engineeringthesis.androidrestapi.language.dto.LanguageDto;
import engineeringthesis.androidrestapi.language.dto.LanguageFilterForm;
import engineeringthesis.androidrestapi.language.dto.UpdateLanguageForm;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static engineeringthesis.androidrestapi.language.controller.LanguageController.Routes.ROOT;
import static engineeringthesis.androidrestapi.language.controller.LanguageController.Routes.ROOT_UUID;

@RestController
@RequiredArgsConstructor
class LanguageController {

    private final LanguageFacade languageFacade;

    static final class Routes {
        static final String ROOT = "/languages";
        static final String ROOT_UUID = ROOT + "/{uuid}";
    }

    @GetMapping(ROOT)
    PageDto<LanguageDto> getAllLanguages(@RequestBody final LanguageFilterForm filterForm, final PageableRequest pageableRequest) {
        return languageFacade.findLanguages(filterForm, pageableRequest);
    }

    @GetMapping(ROOT_UUID)
    LanguageDto findLanguage(@PathVariable final UUID uuid) {
        return languageFacade.findLanguage(uuid);
    }

    @PostMapping(ROOT)
    @ResponseStatus(HttpStatus.CREATED)
    UuidDto saveLanguage(@RequestBody final CreateLanguageForm languageForm) {
        return languageFacade.saveLanguage(languageForm);
    }

    @PutMapping(ROOT_UUID)
    void updateLanguage(@PathVariable final UUID uuid, @RequestBody final UpdateLanguageForm languageForm) {
        languageFacade.updateLanguage(uuid, languageForm);
    }

    @DeleteMapping(ROOT_UUID)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteLanguage(@PathVariable final UUID uuid) {
        languageFacade.deleteLanguage(uuid);
    }
}

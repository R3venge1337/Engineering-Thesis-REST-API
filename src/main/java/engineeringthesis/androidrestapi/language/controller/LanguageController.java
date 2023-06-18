package engineeringthesis.androidrestapi.language.controller;

import java.util.List;
import java.util.Optional;

import engineeringthesis.androidrestapi.language.LanguageFacade;
import engineeringthesis.androidrestapi.language.dto.LanguageDTO;
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
@RequestMapping(value = "/api/languages")
@RequiredArgsConstructor
class LanguageController {

	private final LanguageFacade languageFacade;

	@GetMapping
	List<LanguageDTO> getAllLanguages() {
		return languageFacade.getAllLanguage();
	}

	@GetMapping(value = "/{languageId}")
	LanguageDTO getLanguageById(@PathVariable Integer languageId) {
		return languageFacade.getOneById(languageId);
	}

	@GetMapping(params = "languageName")
	Optional<LanguageDTO> getLanguageByName(@RequestParam("languageName") String languageName) {
		return Optional.ofNullable(Optional.of(languageFacade.getOneByName(languageName)).orElse(new LanguageDTO()));
	}

	@PostMapping
	LanguageDTO saveLanguage(@RequestBody LanguageDTO lang) {
		return languageFacade.saveLanguage(lang);
	}

	@PutMapping(value = "/{languageId}")
	void updateLanguage(@RequestBody LanguageDTO lang, @PathVariable Integer languageId) {
		languageFacade.updateLanguage(languageId, lang);
	}

	@DeleteMapping(value = "/{languageId}")
	void deleteLanguage(@PathVariable Integer languageId) {
		languageFacade.deleteLanguage(languageId);
	}
}

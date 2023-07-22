package engineeringthesis.androidrestapi.language;

import engineeringthesis.androidrestapi.language.dto.CreateLanguageForm;
import engineeringthesis.androidrestapi.language.dto.LanguageDto;
import engineeringthesis.androidrestapi.language.dto.UpdateLanguageForm;

import java.util.List;
import java.util.UUID;

public interface LanguageFacade {
	 
	List<LanguageDto> getAllLanguage();
	
	LanguageDto saveLanguage(final CreateLanguageForm languageForm);

	LanguageDto findLanguage(final UUID uuid);
	
	void updateLanguage(final UUID uuid, final UpdateLanguageForm languageForm);
	
	void deleteLanguage(final UUID uuid);
}

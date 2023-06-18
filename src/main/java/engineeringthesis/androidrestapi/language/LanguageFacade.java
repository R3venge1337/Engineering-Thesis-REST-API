package engineeringthesis.androidrestapi.language;

import engineeringthesis.androidrestapi.language.dto.LanguageDTO;

import java.util.List;

public interface LanguageFacade {
	 
	List<LanguageDTO> getAllLanguage();
	
	LanguageDTO saveLanguage(LanguageDTO lang);
	
	LanguageDTO getOneByName(String name);
	
	LanguageDTO getOneById(Integer languageId);
	
	LanguageDTO updateLanguage(Integer languageId,LanguageDTO lang);
	
	void deleteLanguage(Integer languageId);
}

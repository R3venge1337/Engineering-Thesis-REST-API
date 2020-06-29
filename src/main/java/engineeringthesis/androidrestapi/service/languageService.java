package engineeringthesis.androidrestapi.service;

import java.util.List;
import java.util.Optional;

import engineeringthesis.androidrestapi.model.language;

public interface languageService {
	 
	List<language> getAllLanguage();
	
	language saveLanguage(language lang);
	
	language getOneByName(String name);
	
	Optional<language> getOneById(Integer languageId);
	
	void deleteLanguage(Integer languageId);
}

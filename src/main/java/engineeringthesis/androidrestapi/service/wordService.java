package engineeringthesis.androidrestapi.service;

import java.util.List;
import java.util.Optional;

import engineeringthesis.androidrestapi.model.word;

public interface wordService {
	List<word> getAllWords();
	
	word saveWord(word wordName);
	
	word getOneByName(String name);
	
	Optional<word> getOneById(Integer wordId);
	
	void deleteWord(Integer wordId);
}

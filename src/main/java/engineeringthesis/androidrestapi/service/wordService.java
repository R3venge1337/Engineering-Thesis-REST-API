package engineeringthesis.androidrestapi.service;

import java.util.List;
import engineeringthesis.androidrestapi.dto.WordDTO;

public interface WordService {
	List<WordDTO> getAllWords();
	
	WordDTO saveWord(WordDTO word);
	
	WordDTO getOneByName(String name);
	
	WordDTO getOneById(Integer wordId);
	
	WordDTO updateWord(Integer wordId,WordDTO word);
	
	void deleteWord(Integer wordId);
}

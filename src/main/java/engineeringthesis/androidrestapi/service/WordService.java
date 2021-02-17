package engineeringthesis.androidrestapi.service;

import java.util.List;

import org.springframework.data.domain.Page;

import engineeringthesis.androidrestapi.dto.WordDTO;

public interface WordService {
	
	List<WordDTO> getAllWords();
	
	WordDTO saveWord(WordDTO word);
	
	WordDTO getWordById(Integer wordId);
	
	WordDTO getWordByName(String wordName);
	
	WordDTO updateWord(Integer wordId,WordDTO word);
	
	void deleteWord(Integer wordId);
	
	Page<WordDTO> getWordsByCategoryName(String categoryName,Integer pageNumber,Integer size);
}

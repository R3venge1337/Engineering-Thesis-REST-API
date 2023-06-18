package engineeringthesis.androidrestapi.word;

import java.util.List;

import engineeringthesis.androidrestapi.word.dto.WordDTO;
import org.springframework.data.domain.Page;

public interface WordFacade {
	
	List<WordDTO> getAllWords();
	
	WordDTO saveWord(WordDTO word);
	
	WordDTO getWordById(Integer wordId);
	
	WordDTO getWordByName(String wordName);
	
	WordDTO updateWord(Integer wordId,WordDTO word);
	
	void deleteWord(Integer wordId);
	
	Page<WordDTO> getWordsByCategoryName(String categoryName,Integer pageNumber,Integer size);
}

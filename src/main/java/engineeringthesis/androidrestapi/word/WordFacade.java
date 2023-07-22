package engineeringthesis.androidrestapi.word;

import engineeringthesis.androidrestapi.word.dto.CreateWordForm;
import engineeringthesis.androidrestapi.word.dto.UpdateWordForm;
import engineeringthesis.androidrestapi.word.dto.WordDto;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface WordFacade {

    List<WordDto> getAllWords();

    WordDto saveWord(final CreateWordForm wordForm);

    WordDto getWordByName(final String wordName);

    WordDto updateWord(final UUID uuid, final UpdateWordForm wordForm);

    void deleteWord(final UUID uuid);

    Page<WordDto> getWordsByCategoryName(final String categoryName, final Integer pageNumber, final Integer size);
}

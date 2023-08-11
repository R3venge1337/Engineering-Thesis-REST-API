package engineeringthesis.androidrestapi.word;

import engineeringthesis.androidrestapi.common.controller.PageDto;
import engineeringthesis.androidrestapi.common.controller.PageableRequest;
import engineeringthesis.androidrestapi.common.controller.UuidDto;
import engineeringthesis.androidrestapi.word.dto.CreateWordForm;
import engineeringthesis.androidrestapi.word.dto.UpdateWordForm;
import engineeringthesis.androidrestapi.word.dto.WordDto;
import engineeringthesis.androidrestapi.word.dto.WordFilterForm;

import java.util.UUID;

public interface WordFacade {

    PageDto<WordDto> findWords(final WordFilterForm filterForm, final PageableRequest pageableRequest);

    UuidDto saveWord(final CreateWordForm wordForm);

    void updateWord(final UUID uuid, final UpdateWordForm wordForm);

    void deleteWord(final UUID uuid);

    PageDto<WordDto> getWordsByCategoryName(final String categoryName, final PageableRequest pageableRequest);
}

package engineeringthesis.androidrestapi.word.domain;

import engineeringthesis.androidrestapi.common.controller.PageDto;
import engineeringthesis.androidrestapi.common.controller.PageableRequest;
import engineeringthesis.androidrestapi.common.controller.PageableUtils;
import engineeringthesis.androidrestapi.common.controller.UuidDto;
import engineeringthesis.androidrestapi.common.exception.NotFoundException;
import engineeringthesis.androidrestapi.common.validation.DtoValidator;
import engineeringthesis.androidrestapi.word.WordFacade;
import engineeringthesis.androidrestapi.word.dto.CreateWordForm;
import engineeringthesis.androidrestapi.word.dto.UpdateWordForm;
import engineeringthesis.androidrestapi.word.dto.WordDto;
import engineeringthesis.androidrestapi.word.dto.WordFilterForm;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.UUID;

@RequiredArgsConstructor
class WordService implements WordFacade {

    private final WordRepository wordRepository;

    @Override
    public PageDto<WordDto> findWords(final WordFilterForm filterForm, final PageableRequest pageableRequest) {
        DtoValidator.validate(filterForm);
        DtoValidator.validate(pageableRequest);

        final WordSpecification wordSpecification = new WordSpecification(filterForm);
        final Page<WordDto> words = wordRepository.findAll(wordSpecification, PageableUtils.createPageable(pageableRequest))
                .map(this::mapToDto);

        return PageableUtils.toDto(words);
    }

    @Override
    @Transactional
    public UuidDto saveWord(final CreateWordForm wordForm) {
        DtoValidator.validate(wordForm);

        final Word word = new Word();
        word.setName(wordForm.name());
        word.setDownloadUri(wordForm.downloadUri());

        return new UuidDto(wordRepository.save(word).getUuid());
    }

    @Override
    @Transactional
    public void updateWord(final UUID uuid, final UpdateWordForm wordForm) {
        DtoValidator.validate(wordForm);

        final Word word = wordRepository.findByUuid(uuid)
                .orElseThrow(() -> new NotFoundException(""));

        word.setName(wordForm.name());
        word.setDownloadUri(wordForm.downloadUri());
    }

    @Override
    @Transactional
    public void deleteWord(final UUID uuid) {
        wordRepository.deleteByUuid(uuid);
    }

    @Override
    public PageDto<WordDto> getWordsByCategoryName(final String categoryName, final PageableRequest pageableRequest) {
        final Page<WordDto> words = wordRepository.findAllByCategory_Name(categoryName, PageableUtils.createPageable(pageableRequest))
                .map(this::mapToDto);

        return PageableUtils.toDto(words);
    }

    WordDto mapToDto(final Word word) {
        return new WordDto(word.getUuid(), word.getName(), word.getDownloadUri());
    }
}

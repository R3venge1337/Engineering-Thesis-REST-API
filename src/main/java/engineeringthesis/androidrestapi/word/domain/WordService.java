package engineeringthesis.androidrestapi.word.domain;

import engineeringthesis.androidrestapi.common.exception.NotFoundException;
import engineeringthesis.androidrestapi.word.WordFacade;
import engineeringthesis.androidrestapi.word.dto.CreateWordForm;
import engineeringthesis.androidrestapi.word.dto.UpdateWordForm;
import engineeringthesis.androidrestapi.word.dto.WordDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
class WordService implements WordFacade {

    private final WordRepository wordRepository;

    @Override
    public List<WordDto> getAllWords() {
        return wordRepository.findAll().stream()
                .map(this::mapToDto)
                .toList();
    }

    @Override
    @Transactional
    public WordDto saveWord(final CreateWordForm wordForm) {

        final Word word = new Word();
        word.setName(wordForm.name());
        word.setDownloadUri(wordForm.downloadUri());

        final Word savedEntity = wordRepository.save(word);
        return mapToDto(savedEntity);
    }

    @Override
    public WordDto getWordByName(final String wordName) {
        return mapToDto(wordRepository.getWordByName(wordName));
    }

    @Override
    @Transactional
    public void deleteWord(final UUID uuid) {
        wordRepository.deleteByUuid(uuid);
    }

    @Override
    @Transactional
    public WordDto updateWord(final UUID uuid, final UpdateWordForm wordForm) {

        final Word word = wordRepository.findByUuid(uuid)
                .orElseThrow(() -> new NotFoundException(""));

        word.setName(wordForm.name());
        word.setDownloadUri(wordForm.downloadUri());
        wordRepository.save(word);

        return mapToDto(word);
    }

    @Override
    public Page<WordDto> getWordsByCategoryName(String categoryName, Integer page, Integer size) {
        int pageNumber = page != null && page > 0 ? page : 0;
        int sizeNumber = size != null && size > 0 ? size : 4;
        return mapToPageDto(wordRepository.findAllByCategory_Name(categoryName, PageRequest.of(pageNumber, sizeNumber)));
    }

    private Page<WordDto> mapToPageDto(Page<Word> pages) {
        return new PageImpl<>(pages.stream().map(this::mapToDto).toList());
    }

    WordDto mapToDto(final Word word) {
        return new WordDto(word.getUuid(), word.getName(), word.getDownloadUri());
    }


}

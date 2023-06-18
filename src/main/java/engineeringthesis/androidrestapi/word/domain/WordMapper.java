package engineeringthesis.androidrestapi.word.domain;

import engineeringthesis.androidrestapi.word.dto.WordDTO;
import org.springframework.stereotype.Component;

import engineeringthesis.androidrestapi.common.entity.Mapper;

@Component
class WordMapper implements Mapper<WordDTO, Word> {

	@Override
	public WordDTO mapOfEntity(Word entity) {
		
		WordDTO wordDTO = WordDTO.builder()
				.wordId(entity.getWordId())
				.wordName(entity.getWordName())
				.wordDownloadUri(entity.getWordDownloadUri())
				.categoryId(entity.getCategoryId())
				.languageId(entity.getLanguageId())
				.imageId(entity.getImageId())
				.audioId(entity.getAudioId())
				.build();
		
		return wordDTO;
	}

	@Override
	public Word mapOfDTO(WordDTO dto) {
		
		Word wordEntity = Word.builder()
				.wordId(dto.getWordId())
				.wordName(dto.getWordName())
				.wordDownloadUri(dto.getWordDownloadUri())
				.categoryId(dto.getCategoryId())
				.languageId(dto.getLanguageId())
				.imageId(dto.getImageId())
				.audioId(dto.getAudioId())
				.build();
		
		return wordEntity;
	}

}

package engineeringthesis.androidrestapi.word;

import org.springframework.stereotype.Component;

import engineeringthesis.androidrestapi.util.Mapper;

@Component
public class WordMapper implements Mapper<WordDTO,WordEntity> {

	@Override
	public WordDTO mapOfEntity(WordEntity entity) {
		
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
	public WordEntity mapOfDTO(WordDTO dto) {
		
		WordEntity wordEntity = WordEntity.builder()
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

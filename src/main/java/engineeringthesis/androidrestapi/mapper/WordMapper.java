package engineeringthesis.androidrestapi.mapper;

import org.springframework.stereotype.Component;

import engineeringthesis.androidrestapi.dto.WordDTO;
import engineeringthesis.androidrestapi.entity.WordEntity;

@Component
public class WordMapper implements Mapper<WordDTO,WordEntity> {

	@Override
	public WordDTO mapOfEntity(WordEntity entity) {
		
		WordDTO wordDTO = WordDTO.builder()
				.wordName(entity.getWordName())
				.build();
		
		return wordDTO;
	}

	@Override
	public WordEntity mapOfDTO(WordDTO dto) {
		
		WordEntity wordEntity = WordEntity.builder()
				.wordName(dto.getWordName())
				.build();
		
		return wordEntity;
	}

}

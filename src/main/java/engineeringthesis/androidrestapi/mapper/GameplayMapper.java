package engineeringthesis.androidrestapi.mapper;

import org.springframework.stereotype.Component;

import engineeringthesis.androidrestapi.dto.GameplayDTO;
import engineeringthesis.androidrestapi.entity.GameplayEntity;

@Component
public class GameplayMapper implements Mapper<GameplayDTO,GameplayEntity> {

	@Override
	public GameplayDTO mapOfEntity(GameplayEntity entity) {
		
		GameplayDTO gamePlayDTO = GameplayDTO.builder()
				.gameplayId(entity.getGameplayId())
				.gameMatchDataStart(entity.getGameMatchDataStart())
				.gameMatchDataEnd(entity.getGameMatchDataEnd())
				.categoryId(entity.getCategoryId())
				.languageId(entity.getLanguageId())
				.gameId(entity.getGameId())
				.questUUID(entity.getQuestUUID())
				.build();
		
		return gamePlayDTO;
	}

	@Override
	public GameplayEntity mapOfDTO(GameplayDTO dto) {
		
		GameplayEntity gamePlayEntity = GameplayEntity.builder()
				.gameplayId(dto.getGameplayId())
				.gameMatchDataStart(dto.getGameMatchDataStart())
				.gameMatchDataEnd(dto.getGameMatchDataEnd())
				.categoryId(dto.getCategoryId())
				.languageId(dto.getLanguageId())
				.gameId(dto.getGameId())
				.questUUID(dto.getQuestUUID())
				.build();
		
		return gamePlayEntity;
	}

}

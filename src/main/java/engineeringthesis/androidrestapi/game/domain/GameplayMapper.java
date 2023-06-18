package engineeringthesis.androidrestapi.game.domain;

import engineeringthesis.androidrestapi.game.dto.GameplayDTO;
import org.springframework.stereotype.Component;

import engineeringthesis.androidrestapi.common.entity.Mapper;

@Component
class GameplayMapper implements Mapper<GameplayDTO, Gameplay> {

	@Override
	public GameplayDTO mapOfEntity(Gameplay entity) {
		
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
	public Gameplay mapOfDTO(GameplayDTO dto) {
		
		Gameplay gamePlayEntity = Gameplay.builder()
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

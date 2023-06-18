package engineeringthesis.androidrestapi.game.domain;

import engineeringthesis.androidrestapi.game.dto.GameplayResultDTO;
import org.springframework.stereotype.Component;

import engineeringthesis.androidrestapi.common.entity.Mapper;
@Component
class GameplayResultMapper implements Mapper<GameplayResultDTO, GameplayResult> {

	@Override
	public GameplayResultDTO mapOfEntity(GameplayResult entity) {
		 
		GameplayResultDTO gameMatchResult =  GameplayResultDTO.builder()
				.gameplayId(entity.getGameplayId())
				.gameplayResultsId(entity.getGameplayResultsId())
				.statisticResultsId(entity.getStatisticResultsId())
				 .build();
		return gameMatchResult;
	}

	@Override
	public GameplayResult mapOfDTO(GameplayResultDTO dto) {
		
		GameplayResult gameMatchResult =  GameplayResult.builder()
				 .gameplayId(dto.getGameplayId())
				 .gameplayResultsId(dto.getGameplayResultsId())
				 .statisticResultsId(dto.getStatisticResultsId())
				 .build();
		return gameMatchResult;
	}

}

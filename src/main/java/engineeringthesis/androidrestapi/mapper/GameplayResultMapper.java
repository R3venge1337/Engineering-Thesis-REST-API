package engineeringthesis.androidrestapi.mapper;

import org.springframework.stereotype.Component;

import engineeringthesis.androidrestapi.dto.GameplayResultDTO;
import engineeringthesis.androidrestapi.entity.GameplayResultEntity;
@Component
public class GameplayResultMapper implements Mapper<GameplayResultDTO,GameplayResultEntity> {

	@Override
	public GameplayResultDTO mapOfEntity(GameplayResultEntity entity) {
		 
		GameplayResultDTO gameMatchResult =  GameplayResultDTO.builder()
				.gameplayId(entity.getGameplayId())
				.gameplayResultsId(entity.getGameplayResultsId())
				.statisticResultsId(entity.getStatisticResultsId())
				 .build();
		return gameMatchResult;
	}

	@Override
	public GameplayResultEntity mapOfDTO(GameplayResultDTO dto) {
		
		GameplayResultEntity gameMatchResult =  GameplayResultEntity.builder()
				 .gameplayId(dto.getGameplayId())
				 .gameplayResultsId(dto.getGameplayResultsId())
				 .statisticResultsId(dto.getStatisticResultsId())
				 .build();
		return gameMatchResult;
	}

}

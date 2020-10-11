package engineeringthesis.androidrestapi.mapper;

import org.springframework.stereotype.Component;

import engineeringthesis.androidrestapi.dto.GameplayResultDTO;
import engineeringthesis.androidrestapi.entity.GameplayResultEntity;
@Component
public class GameplayResultMapper implements Mapper<GameplayResultDTO,GameplayResultEntity> {

	@Override
	public GameplayResultDTO mapOfEntity(GameplayResultEntity entity) {
		 
		GameplayResultDTO gameMatchResult =  GameplayResultDTO.builder()
				 .gameplayResultsId(entity.getGameplayResultsId())
				 .build();
		return gameMatchResult;
	}

	@Override
	public GameplayResultEntity mapOfDTO(GameplayResultDTO dto) {
		
		GameplayResultEntity gameMatchResult =  GameplayResultEntity.builder()
				 .gameplayResultsId(dto.getGameplayResultsId())
				 .build();
		return gameMatchResult;
	}

}

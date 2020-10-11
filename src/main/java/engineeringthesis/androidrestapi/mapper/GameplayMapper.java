package engineeringthesis.androidrestapi.mapper;

import org.springframework.stereotype.Component;

import engineeringthesis.androidrestapi.dto.GameplayDTO;
import engineeringthesis.androidrestapi.entity.GameplayEntity;

@Component
public class GameplayMapper implements Mapper<GameplayDTO,GameplayEntity> {

	@Override
	public GameplayDTO mapOfEntity(GameplayEntity entity) {
		
		GameplayDTO gamePlayDTO = GameplayDTO.builder()
				.gameMatchDataStart(entity.getGameMatchDataStart())
				.gameMatchDataEnd(entity.getGameMatchDataEnd())
				.build();
		
		return gamePlayDTO;
	}

	@Override
	public GameplayEntity mapOfDTO(GameplayDTO dto) {
		
		GameplayEntity gamePlayEntity = GameplayEntity.builder()
				.gameMatchDataStart(dto.getGameMatchDataStart())
				.gameMatchDataEnd(dto.getGameMatchDataEnd())
				.build();
		
		return gamePlayEntity;
	}

}

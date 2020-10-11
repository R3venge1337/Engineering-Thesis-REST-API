package engineeringthesis.androidrestapi.mapper;

import org.springframework.stereotype.Component;

import engineeringthesis.androidrestapi.dto.GameDTO;
import engineeringthesis.androidrestapi.entity.GameEntity;

@Component
public class GameMapper implements Mapper<GameDTO,GameEntity> {

	@Override
	public GameDTO mapOfEntity(GameEntity entity) {
		
		GameDTO gameDTO = GameDTO.builder()
				.gameId(entity.getGameId())
				.gameName(entity.getGameName())
				.build();
		
		return gameDTO;
	}

	@Override
	public GameEntity mapOfDTO(GameDTO dto) {
		
		GameEntity gameEntity = GameEntity.builder()
				.gameId(dto.getGameId())
				.gameName(dto.getGameName())
				.build();
		
		return gameEntity;
	}

}

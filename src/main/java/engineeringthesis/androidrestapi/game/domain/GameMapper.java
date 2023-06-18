package engineeringthesis.androidrestapi.game.domain;

import engineeringthesis.androidrestapi.game.dto.GameDTO;
import org.springframework.stereotype.Component;

import engineeringthesis.androidrestapi.common.entity.Mapper;

@Component
class GameMapper implements Mapper<GameDTO, Game> {

	@Override
	public GameDTO mapOfEntity(Game entity) {
		
		GameDTO gameDTO = GameDTO.builder()
				.gameId(entity.getGameId())
				.gameName(entity.getGameName())
				.build();
		
		return gameDTO;
	}

	@Override
	public Game mapOfDTO(GameDTO dto) {
		
		Game gameEntity = Game.builder()
				.gameId(dto.getGameId())
				.gameName(dto.getGameName())
				.build();
		
		return gameEntity;
	}

}

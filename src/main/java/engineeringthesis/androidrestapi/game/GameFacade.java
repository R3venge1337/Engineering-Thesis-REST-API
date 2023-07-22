package engineeringthesis.androidrestapi.game;

import engineeringthesis.androidrestapi.game.dto.CreateGameForm;
import engineeringthesis.androidrestapi.game.dto.GameDto;
import engineeringthesis.androidrestapi.game.dto.UpdateGameForm;

import java.util.List;
import java.util.UUID;

public interface GameFacade {
	

	List<GameDto> getAllGames();
	
	GameDto saveGame(final CreateGameForm gameForm);

	GameDto findGame(final UUID uuid);
	void updateGame(final UUID uuid, final UpdateGameForm gameForm);
	
	void deleteGame(final UUID uuid);
}

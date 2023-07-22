package engineeringthesis.androidrestapi.game;

import engineeringthesis.androidrestapi.game.dto.CreateGameplayForm;
import engineeringthesis.androidrestapi.game.dto.GameplayDto;
import engineeringthesis.androidrestapi.game.dto.UpdateGameplayForm;

import java.util.List;
import java.util.UUID;


public interface GameplayFacade {

	List<GameplayDto> getAllGameplay();
	
	GameplayDto saveGameplay(final CreateGameplayForm gameplayForm);

	GameplayDto findGameplay(final UUID uuid);
	
	void updateGameplay(final UUID uuid, final UpdateGameplayForm gameplayForm);
	
	void deleteGameplay(final UUID uuid);
}

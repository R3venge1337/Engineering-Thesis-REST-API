package engineeringthesis.androidrestapi.game;

import engineeringthesis.androidrestapi.game.dto.CreateGameplayResultForm;
import engineeringthesis.androidrestapi.game.dto.GameplayResultDto;
import engineeringthesis.androidrestapi.game.dto.UpdateGameplayResultForm;

import java.util.List;
import java.util.UUID;

public interface GameplayResultFacade {
	
	List<GameplayResultDto> getAllGameplayResults();

	List<GameplayResultDto> getAllGameplayResultsByGameplayId(final UUID uuid);
	
	List<GameplayResultDto>getAllUserResultsByGuestId(final String guestUUID);
	
	List<GameplayResultDto>getAllUserResultsByGameName(final String gameName);
	
	GameplayResultDto saveGameplayResults(final CreateGameplayResultForm resultForm);

	void updateGameplayResults(final UUID uuid, final UpdateGameplayResultForm resultForm);
	
	void deleteGameplayResults(final UUID uuid);
	
	
}

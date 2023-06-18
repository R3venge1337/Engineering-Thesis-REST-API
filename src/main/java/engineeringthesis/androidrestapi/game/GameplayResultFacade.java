package engineeringthesis.androidrestapi.game;

import engineeringthesis.androidrestapi.game.dto.GameplayResultDTO;

import java.util.List;

public interface GameplayResultFacade {
	
	List<GameplayResultDTO> getAllGameplayResults();
	
	List<GameplayResultDTO> getAllGameplayResultsByGameplayId(Integer gameplayId);
	
	List<GameplayResultDTO>getAllUserResultsByGuestId(String guestUUID);
	
	List<GameplayResultDTO>getAllUserResultsByGameName(String gameName);
	
	GameplayResultDTO saveGameplayResults(GameplayResultDTO result);
	
	GameplayResultDTO getOneByName(String name);
	
	GameplayResultDTO getOneById(Integer resultId);
	
	GameplayResultDTO updateGameplayResults(Integer resultId,GameplayResultDTO result);
	
	void deleteGameplayResults(Integer resultId);
	
	
}

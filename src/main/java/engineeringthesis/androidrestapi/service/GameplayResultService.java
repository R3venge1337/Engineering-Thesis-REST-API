package engineeringthesis.androidrestapi.service;

import java.util.List;


import engineeringthesis.androidrestapi.dto.GameplayResultDTO;

public interface GameplayResultService {
	
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

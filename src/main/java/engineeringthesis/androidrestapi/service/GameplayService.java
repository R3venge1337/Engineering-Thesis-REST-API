package engineeringthesis.androidrestapi.service;

import java.util.List;

import engineeringthesis.androidrestapi.dto.GameplayDTO;



public interface GameplayService {

	List<GameplayDTO> getAllGameplay();
	
	GameplayDTO saveGameplay(GameplayDTO gameplayObj);
	
	GameplayDTO getOneByName(String name);
	
	GameplayDTO getOneById(Integer gameplayId);
	
	GameplayDTO updateGameplay(Integer gameplayId,GameplayDTO gameplayObj);
	
	void deleteGameplay(Integer gameMatchId);
}

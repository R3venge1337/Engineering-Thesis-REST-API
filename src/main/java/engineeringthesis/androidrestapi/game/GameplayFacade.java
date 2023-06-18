package engineeringthesis.androidrestapi.game;

import engineeringthesis.androidrestapi.game.dto.GameplayDTO;

import java.util.List;



public interface GameplayFacade {

	List<GameplayDTO> getAllGameplay();
	
	GameplayDTO saveGameplay(GameplayDTO gameplayObj);
	
	GameplayDTO getOneByName(String name);
	
	GameplayDTO getOneById(Integer gameplayId);
	
	GameplayDTO updateGameplay(Integer gameplayId,GameplayDTO gameplayObj);
	
	void deleteGameplay(Integer gameMatchId);
}

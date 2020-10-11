package engineeringthesis.androidrestapi.service;

import java.util.List;

import engineeringthesis.androidrestapi.dto.GameDTO;

public interface GameService {
	

	List<GameDTO> getAllGames();
	
	GameDTO saveGame(GameDTO gameName);
	
	GameDTO getOneByName(String name);
	
	GameDTO getOneById(Integer gameId);
	
	GameDTO updateGame(Integer gameId, GameDTO gameName);
	
	void deleteGame(Integer gameId);
}

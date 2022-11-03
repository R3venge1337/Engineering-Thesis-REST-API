package engineeringthesis.androidrestapi.game;

import java.util.List;

public interface GameService {
	

	List<GameDTO> getAllGames();
	
	GameDTO saveGame(GameDTO gameName);
	
	GameDTO getOneByName(String name);
	
	GameDTO getOneById(Integer gameId);
	
	GameDTO updateGame(Integer gameId, GameDTO gameName);
	
	void deleteGame(Integer gameId);
}

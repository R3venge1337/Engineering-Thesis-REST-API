package engineeringthesis.androidrestapi.service;

import java.util.List;
import java.util.Optional;

import engineeringthesis.androidrestapi.model.game;

public interface gameService {
	

	List<game> getAllGames();
	
	game saveGame(game gameName);
	
	game getOneByName(String name);
	
	Optional<game> getOneById(Integer gameId);
	
	void deleteGame(Integer gameId);
}

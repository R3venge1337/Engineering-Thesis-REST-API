package engineeringthesis.androidrestapi.service;

import java.util.List;
import java.util.Optional;

import engineeringthesis.androidrestapi.model.gameMatch;



public interface gameMatchService {

	List<gameMatch> getAllGameMatch();
	
	gameMatch saveGameMatch(gameMatch game);
	
	gameMatch getOneByName(String name);
	
	Optional<gameMatch> getOneById(Integer gameMatchId);
	
	void deleteGameMatch(Integer gameMatchId);
}

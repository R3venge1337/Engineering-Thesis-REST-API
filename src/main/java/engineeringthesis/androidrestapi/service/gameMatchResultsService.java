package engineeringthesis.androidrestapi.service;

import java.util.List;
import java.util.Optional;

import engineeringthesis.androidrestapi.model.gameMatchResults;

public interface gameMatchResultsService {
	
	List<gameMatchResults> getAllgameMatchResults();
	
	gameMatchResults savegameMatchResults(gameMatchResults result);
	
	gameMatchResults getOneByName(String name);
	
	Optional<gameMatchResults> getOneById(Integer resultId);
	
	void deleteGameMatchResults(Integer resultId);
}

package engineeringthesis.androidrestapi.serviceImpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import engineeringthesis.androidrestapi.model.game;
import engineeringthesis.androidrestapi.repository.gameRepository;
import engineeringthesis.androidrestapi.service.gameService;

@Service
@Transactional
public class gameServiceImpl implements gameService {

	@Autowired
	gameRepository gameRepository;
	
	@Override
	public List<game> getAllGames() {
		return gameRepository.findAll();
	}

	@Override
	public game saveGame(game gameName) {
		
		return gameRepository.save(gameName);
	}

	@Override
	public game getOneByName(String name) {
		return null;
	}

	@Override
	public Optional<game> getOneById(Integer gameId) {
		return gameRepository.findById(gameId);
	}

	@Override
	public void deleteGame(Integer gameId) {
		gameRepository.deleteById(gameId);
	}
	
}

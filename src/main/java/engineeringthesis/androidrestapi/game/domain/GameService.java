package engineeringthesis.androidrestapi.game.domain;

import java.util.List;
import java.util.Optional;


import engineeringthesis.androidrestapi.game.GameFacade;
import engineeringthesis.androidrestapi.game.dto.GameDTO;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class GameService implements GameFacade {

private final GameRepository gameRepository;
private final GameMapper gameMapper;
	
	@Override
	public List<GameDTO> getAllGames() {
		
		return gameMapper.mapOfCollection(gameRepository.findAll());
	}

	@Override
	public GameDTO saveGame(GameDTO game) {
		
		Game gameEntity = gameMapper.mapOfDTO(game);
		Game savedEntity =  gameRepository.save(gameEntity);
		return gameMapper.mapOfEntity(savedEntity);
	}

	@Override
	public GameDTO getOneByName(String name) {
		
		return gameMapper.mapOfEntity(gameRepository.findByGameName(name));
	}

	@Override
	public GameDTO getOneById(Integer gameId) {
		
		return gameMapper.mapOfEntity(gameRepository.findById(gameId).get());
	}
	
	@Override
	public GameDTO updateGame(Integer gameId, GameDTO gameName) {
		
		Optional<Game> gameEntity = gameRepository.findById(gameId);
		Game savedEntity = gameEntity.get();
		savedEntity.setGameName(gameName.getGameName());
		gameRepository.save(savedEntity);
		GameDTO dto = gameMapper.mapOfEntity(savedEntity);
		return dto;
	}

	@Override
	public void deleteGame(Integer gameId) {
		
		gameRepository.deleteById(gameId);
	}

	
	
}

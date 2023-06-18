package engineeringthesis.androidrestapi.game.domain;

import java.util.List;
import java.util.Optional;

import engineeringthesis.androidrestapi.game.GameplayFacade;
import engineeringthesis.androidrestapi.game.dto.GameplayDTO;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class GameplayService implements GameplayFacade {

	
	
	private final GameplayRepository gameplayRepository;
	private final GameplayMapper gameplayMapper;
	
	@Override
	public List<GameplayDTO> getAllGameplay() {
		
		return  gameplayMapper.mapOfCollection(gameplayRepository.findAll());
	}

	@Override
	public GameplayDTO saveGameplay(GameplayDTO gameMatch) {
		
		Gameplay gamePlayEntity = gameplayMapper.mapOfDTO(gameMatch);
		Gameplay savedEntity = gameplayRepository.save(gamePlayEntity);
		return  gameplayMapper.mapOfEntity(savedEntity);
	}

	@Override
	public GameplayDTO getOneByName(String name) {
		
		return null;
	}

	@Override
	public GameplayDTO getOneById(Integer gameMatchId) {
		
		return  gameplayMapper.mapOfEntity(gameplayRepository.findById(gameMatchId).get());
	}
	
	@Override
	public GameplayDTO updateGameplay(Integer gameplayId, GameplayDTO gameplayObj) {
		
		Optional<Gameplay> gameMatch = gameplayRepository.findById(gameplayId);
		Gameplay savedEntity = gameMatch.get();
		savedEntity.setGameMatchDataStart(gameplayObj.getGameMatchDataStart());
		savedEntity.setGameMatchDataEnd(gameplayObj.getGameMatchDataEnd());
		gameplayRepository.save(savedEntity);
		GameplayDTO dto = gameplayMapper.mapOfEntity(savedEntity);
		return dto;
	}

	@Override
	public void deleteGameplay(Integer gameMatchId) {
		 
		gameplayRepository.deleteById(gameMatchId);
	}


	

}

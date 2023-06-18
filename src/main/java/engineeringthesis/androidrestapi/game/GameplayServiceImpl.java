package engineeringthesis.androidrestapi.game;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class GameplayServiceImpl implements GameplayService  {

	
	
	private final GameplayRepository gameplayRepository;
	private final GameplayMapper gameplayMapper;
	
	@Override
	public List<GameplayDTO> getAllGameplay() {
		
		return  gameplayMapper.mapOfCollection(gameplayRepository.findAll());
	}

	@Override
	public GameplayDTO saveGameplay(GameplayDTO gameMatch) {
		
		GameplayEntity gamePlayEntity = gameplayMapper.mapOfDTO(gameMatch);
		GameplayEntity savedEntity = gameplayRepository.save(gamePlayEntity);
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
		
		Optional<GameplayEntity> gameMatch = gameplayRepository.findById(gameplayId);
		GameplayEntity savedEntity = gameMatch.get();
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

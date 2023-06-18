package engineeringthesis.androidrestapi.game.domain;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import engineeringthesis.androidrestapi.game.GameplayResultFacade;
import engineeringthesis.androidrestapi.game.dto.GameplayResultDTO;
import org.springframework.stereotype.Service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class GameplayResultService implements GameplayResultFacade {

	
	private final GameplayResultsRepository gameplayResultsRepository;
	private final GameplayResultMapper gameplayResultMapper;
	
	@Override
	public List<GameplayResultDTO> getAllGameplayResults() {
		return gameplayResultMapper.mapOfCollection(gameplayResultsRepository.findAll());
	}

	@Override
	public GameplayResultDTO saveGameplayResults(GameplayResultDTO result) {
		
		GameplayResult gameMatchResult = gameplayResultMapper.mapOfDTO(result);
		GameplayResult savedEntity = gameplayResultsRepository.save(gameMatchResult);
		return gameplayResultMapper.mapOfEntity(savedEntity);
	}

	@Override
	public GameplayResultDTO getOneByName(String name) {
		
		return null;
	}

	@Override
	public GameplayResultDTO getOneById(Integer resultId) {
		
		return gameplayResultMapper.mapOfEntity(gameplayResultsRepository.findById(resultId).get());
	}
	
	@Override
	public List<GameplayResultDTO> getAllGameplayResultsByGameplayId(Integer gameplayId) {
		
		return gameplayResultMapper.mapOfCollection(gameplayResultsRepository.findByGameplayId(gameplayId));
	}
	
	@Override
	public GameplayResultDTO updateGameplayResults(Integer resultId, GameplayResultDTO result) {
		
		Optional<GameplayResult> accountEntity = gameplayResultsRepository.findById(resultId);
		GameplayResult savedEntity = accountEntity.get();
		savedEntity.setGameplayResultsId(result.getGameplayResultsId());
		gameplayResultsRepository.save(savedEntity);
		GameplayResultDTO dto = gameplayResultMapper.mapOfEntity(savedEntity);
		return dto;
	}

	@Override
	public void deleteGameplayResults(Integer resultId) {
		gameplayResultsRepository.deleteById(resultId);
	}

	@Override
	public List<GameplayResultDTO> getAllUserResultsByGuestId(String guestUUID) {
		
		return gameplayResultMapper.mapOfCollection(gameplayResultsRepository.getAllUserResultsByGuestId(guestUUID));
	}

	@Override
	public List<GameplayResultDTO> getAllUserResultsByGameName(String gameName) {
		
		return gameplayResultMapper.mapOfCollection(gameplayResultsRepository.getAllUserResultsByGameName(gameName));
	}

	

	

}

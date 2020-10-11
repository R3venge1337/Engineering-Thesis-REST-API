package engineeringthesis.androidrestapi.serviceImpl;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import engineeringthesis.androidrestapi.dto.GameplayResultDTO;
import engineeringthesis.androidrestapi.entity.GameplayResultEntity;
import engineeringthesis.androidrestapi.mapper.GameplayResultMapper;
import engineeringthesis.androidrestapi.repository.GameplayResultsRepository;
import engineeringthesis.androidrestapi.service.GameplayResultService;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class GameplayResultServiceImpl implements GameplayResultService {

	
	private final GameplayResultsRepository gameplayResultsRepository;
	private final GameplayResultMapper gameplayResultMapper;
	
	@Override
	public List<GameplayResultDTO> getAllGameplayResults() {
		return gameplayResultMapper.mapOfCollection(gameplayResultsRepository.findAll());
	}

	@Override
	public GameplayResultDTO saveGameplayResults(GameplayResultDTO result) {
		
		GameplayResultEntity gameMatchResult = gameplayResultMapper.mapOfDTO(result);
		GameplayResultEntity savedEntity = gameplayResultsRepository.save(gameMatchResult);
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
		
		Optional<GameplayResultEntity> accountEntity = gameplayResultsRepository.findById(resultId);
		GameplayResultEntity savedEntity = accountEntity.get();
		savedEntity.setGameplayResultsId(result.getGameplayResultsId());
		gameplayResultsRepository.save(savedEntity);
		GameplayResultDTO dto = gameplayResultMapper.mapOfEntity(savedEntity);
		return dto;
	}

	@Override
	public void deleteGameplayResults(Integer resultId) {
		gameplayResultsRepository.deleteById(resultId);
	}

	

	

}

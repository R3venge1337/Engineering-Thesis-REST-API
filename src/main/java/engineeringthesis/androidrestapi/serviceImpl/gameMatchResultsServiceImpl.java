package engineeringthesis.androidrestapi.serviceImpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import engineeringthesis.androidrestapi.model.gameMatchResults;
import engineeringthesis.androidrestapi.repository.gameMatchResultsRepository;
import engineeringthesis.androidrestapi.service.gameMatchResultsService;

@Service
@Transactional
public class gameMatchResultsServiceImpl implements gameMatchResultsService {

	@Autowired
	gameMatchResultsRepository gameMatchResultRepository;
	
	@Override
	public List<gameMatchResults> getAllgameMatchResults() {
		return gameMatchResultRepository.findAll();
	}

	@Override
	public gameMatchResults savegameMatchResults(gameMatchResults result) {
		return gameMatchResultRepository.save(result);
	}

	@Override
	public gameMatchResults getOneByName(String name) {
		return null;
	}

	@Override
	public Optional<gameMatchResults> getOneById(Integer resultId) {
		
		return gameMatchResultRepository.findById(resultId);
	}

	@Override
	public void deleteGameMatchResults(Integer resultId) {
		gameMatchResultRepository.deleteById(resultId);
	}

}

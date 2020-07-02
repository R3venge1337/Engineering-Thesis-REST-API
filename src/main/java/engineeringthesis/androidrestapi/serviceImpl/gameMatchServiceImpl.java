package engineeringthesis.androidrestapi.serviceImpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import engineeringthesis.androidrestapi.model.gameMatch;
import engineeringthesis.androidrestapi.repository.gameMatchRepository;
import engineeringthesis.androidrestapi.service.gameMatchService;

@Service
@Transactional
public class gameMatchServiceImpl implements gameMatchService  {

	
	@Autowired
	gameMatchRepository gameMatchRepository;
	
	@Override
	public List<gameMatch> getAllGameMatch() {
		return  gameMatchRepository.findAll();
	}

	@Override
	public gameMatch saveGameMatch(gameMatch game) {

		return  gameMatchRepository.save(game);
	}

	@Override
	public gameMatch getOneByName(String name) {
		return null;
	}

	@Override
	public Optional<gameMatch> getOneById(Integer gameMatchId) {
		return  gameMatchRepository.findById(gameMatchId);
	}

	@Override
	public void deleteGameMatch(Integer gameMatchId) {
		 gameMatchRepository.deleteById(gameMatchId);
		
	}

}

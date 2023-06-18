package engineeringthesis.androidrestapi.game;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/matches")
class GameplayController {

	@Autowired
	private GameplayServiceImpl gameplayServiceImpl;

	@GetMapping
	List<GameplayDTO> getAllGameplays() {
		return gameplayServiceImpl.getAllGameplay();
	}

	@GetMapping(value = "{gameplayId}")
	GameplayDTO getGameplayById(@PathVariable Integer gameplayId) {
		return gameplayServiceImpl.getOneById(gameplayId);
	}

	@PostMapping
	GameplayDTO saveGameplay(@RequestBody GameplayDTO gameMatchObj) {
		return gameplayServiceImpl.saveGameplay(gameMatchObj);
	}

	@PutMapping(value = "/{gameplayId}")
	GameplayDTO updateGameplay(@RequestBody GameplayDTO gameplayObj, @PathVariable Integer gameplayId) {
		return gameplayServiceImpl.updateGameplay(gameplayId, gameplayObj);
	}

	@DeleteMapping(value = "/{gameMatchId}")
	void deleteGameplayById(@PathVariable Integer gameMatchId) {
		gameplayServiceImpl.deleteGameplay(gameMatchId);
	}
}

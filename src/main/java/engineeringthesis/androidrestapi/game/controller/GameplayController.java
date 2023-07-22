package engineeringthesis.androidrestapi.game.controller;

import java.util.List;
import java.util.UUID;

import engineeringthesis.androidrestapi.game.GameplayFacade;
import engineeringthesis.androidrestapi.game.dto.CreateGameplayForm;
import engineeringthesis.androidrestapi.game.dto.GameplayDto;
import engineeringthesis.androidrestapi.game.dto.UpdateGameplayForm;
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
	private GameplayFacade gameplayFacade;

	@GetMapping
	List<GameplayDto> getAllGameplays() {
		return gameplayFacade.getAllGameplay();
	}

	@GetMapping(value = "/{uuid}")
    GameplayDto findGameplay(@PathVariable final UUID uuid) {
		return gameplayFacade.findGameplay(uuid);
	}

	@PostMapping
    GameplayDto saveGameplay(@RequestBody final CreateGameplayForm gameplayForm) {
		return gameplayFacade.saveGameplay(gameplayForm);
	}

	@PutMapping(value = "/{uuid}")
    void updateGameplay(@PathVariable final UUID uuid, @RequestBody final UpdateGameplayForm gameplayForm) {
		gameplayFacade.updateGameplay(uuid, gameplayForm);
	}

	@DeleteMapping(value = "/{uuid}")
	void deleteGameplay(@PathVariable final UUID uuid) {
		gameplayFacade.deleteGameplay(uuid);
	}
}
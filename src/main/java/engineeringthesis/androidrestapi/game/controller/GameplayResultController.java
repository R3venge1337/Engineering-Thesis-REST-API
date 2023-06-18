package engineeringthesis.androidrestapi.game.controller;

import java.util.List;

import engineeringthesis.androidrestapi.game.GameplayResultFacade;
import engineeringthesis.androidrestapi.game.dto.GameplayResultDTO;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api/results")
@RequiredArgsConstructor
class GameplayResultController {

	private final GameplayResultFacade gameplayResultFacade;

	@GetMapping
	List<GameplayResultDTO> getAllGameplayResults() {
		return gameplayResultFacade.getAllGameplayResults();
	}

	@GetMapping(value = "/{gameplayResultsId}")
	GameplayResultDTO getGameplayResultById(@PathVariable Integer gameplayResultsId) {
		return gameplayResultFacade.getOneById(gameplayResultsId);
	}

	@GetMapping(value = "/gameplay/{gameplayId}")
	List<GameplayResultDTO> getAllGameplayResultsByGameplayId(@PathVariable Integer gameplayId) {
		return gameplayResultFacade.getAllGameplayResultsByGameplayId(gameplayId);
	}

	@PostMapping
	GameplayResultDTO saveGameplay(@RequestBody GameplayResultDTO gameplayResultsObj) {
		return gameplayResultFacade.saveGameplayResults(gameplayResultsObj);
	}

	@PutMapping(value = "/{gameplayId}")
	GameplayResultDTO updateGameplayResults(@RequestBody GameplayResultDTO gameplayResultsObj,
			@PathVariable Integer gameplayId) {
		return gameplayResultFacade.updateGameplayResults(gameplayId, gameplayResultsObj);
	}

	@DeleteMapping
	void deleteGameplayResultsById(@PathVariable Integer gameplayResultsId) {
		gameplayResultFacade.deleteGameplayResults(gameplayResultsId);
	}

	@GetMapping(value = "/child/{guestUUID}")
	List<GameplayResultDTO> getAllUserResultsByGuestId(@PathVariable String guestUUID) {
		return gameplayResultFacade.getAllUserResultsByGuestId(guestUUID);
	}

	@GetMapping(value = "/game/{gameName}")
	List<GameplayResultDTO> getAllGameplayResultsByGameName(@PathVariable String gameName) {
		return gameplayResultFacade.getAllUserResultsByGameName(gameName);
	}

}

package engineeringthesis.androidrestapi.game.controller;

import java.util.List;

import engineeringthesis.androidrestapi.game.dto.GameplayResultDTO;
import engineeringthesis.androidrestapi.game.domain.GameplayResultServiceImpl;
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

	private final GameplayResultServiceImpl gameplayResultServiceImpl;

	@GetMapping
	List<GameplayResultDTO> getAllGameplayResults() {
		return gameplayResultServiceImpl.getAllGameplayResults();
	}

	@GetMapping(value = "/{gameplayResultsId}")
	GameplayResultDTO getGameplayResultById(@PathVariable Integer gameplayResultsId) {
		return gameplayResultServiceImpl.getOneById(gameplayResultsId);
	}

	@GetMapping(value = "/gameplay/{gameplayId}")
	List<GameplayResultDTO> getAllGameplayResultsByGameplayId(@PathVariable Integer gameplayId) {
		return gameplayResultServiceImpl.getAllGameplayResultsByGameplayId(gameplayId);
	}

	@PostMapping
	GameplayResultDTO saveGameplay(@RequestBody GameplayResultDTO gameplayResultsObj) {
		return gameplayResultServiceImpl.saveGameplayResults(gameplayResultsObj);
	}

	@PutMapping(value = "/{gameplayId}")
	GameplayResultDTO updateGameplayResults(@RequestBody GameplayResultDTO gameplayResultsObj,
			@PathVariable Integer gameplayId) {
		return gameplayResultServiceImpl.updateGameplayResults(gameplayId, gameplayResultsObj);
	}

	@DeleteMapping
	void deleteGameplayResultsById(@PathVariable Integer gameplayResultsId) {
		gameplayResultServiceImpl.deleteGameplayResults(gameplayResultsId);
	}

	@GetMapping(value = "/child/{guestUUID}")
	List<GameplayResultDTO> getAllUserResultsByGuestId(@PathVariable String guestUUID) {
		return gameplayResultServiceImpl.getAllUserResultsByGuestId(guestUUID);
	}

	@GetMapping(value = "/game/{gameName}")
	List<GameplayResultDTO> getAllGameplayResultsByGameName(@PathVariable String gameName) {
		return gameplayResultServiceImpl.getAllUserResultsByGameName(gameName);
	}

}

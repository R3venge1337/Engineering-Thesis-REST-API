package engineeringthesis.androidrestapi.game.controller;

import java.util.List;

import engineeringthesis.androidrestapi.game.GameFacade;
import engineeringthesis.androidrestapi.game.dto.GameDTO;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api/games")
@RequiredArgsConstructor
class GameController {

	private final GameFacade gameFacade;

	@GetMapping
	List<GameDTO> getAllGames() {
		return gameFacade.getAllGames();
	}

	@GetMapping(value = "/{gameId}")
	GameDTO getGameById(@PathVariable Integer gameId) {
		return gameFacade.getOneById(gameId);
	}

	@GetMapping(params = "gameName")
	GameDTO getGameByName(@RequestParam("gameName") String gameName) {
		return gameFacade.getOneByName(gameName);
	}

	@PostMapping
	GameDTO saveGame(@RequestBody GameDTO gameObj) {
		return gameFacade.saveGame(gameObj);
	}

	@PutMapping(value = "/{gameId}")
	void updateGame(@PathVariable Integer gameId, @RequestBody GameDTO gameObj) {
		gameFacade.updateGame(gameId, gameObj);
	}

	@DeleteMapping(value = "/{gameId}")
	void deleteGame(@PathVariable Integer gameId) {
		gameFacade.deleteGame(gameId);
	}
}

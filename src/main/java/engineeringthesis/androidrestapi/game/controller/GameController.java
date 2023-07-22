package engineeringthesis.androidrestapi.game.controller;

import engineeringthesis.androidrestapi.game.GameFacade;
import engineeringthesis.androidrestapi.game.dto.CreateGameForm;
import engineeringthesis.androidrestapi.game.dto.GameDto;
import engineeringthesis.androidrestapi.game.dto.UpdateGameForm;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/games")
@RequiredArgsConstructor
class GameController {

    private final GameFacade gameFacade;

    @GetMapping
    List<GameDto> getAllGames() {
        return gameFacade.getAllGames();
    }

    @GetMapping(value = "/{uuid}")
    GameDto findGame(@PathVariable final UUID uuid) {
        return gameFacade.findGame(uuid);
    }

    @PostMapping
    GameDto saveGame(@RequestBody final CreateGameForm gameForm) {
        return gameFacade.saveGame(gameForm);
    }

    @PutMapping(value = "/{uuid}")
    void updateGame(@PathVariable final UUID uuid, @RequestBody final UpdateGameForm gameForm) {
        gameFacade.updateGame(uuid, gameForm);
    }

    @DeleteMapping(value = "/{uuid}")
    void deleteGame(@PathVariable final UUID uuid) {
        gameFacade.deleteGame(uuid);
    }
}

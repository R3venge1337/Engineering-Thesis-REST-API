package engineeringthesis.androidrestapi.game.controller;

import engineeringthesis.androidrestapi.common.controller.PageDto;
import engineeringthesis.androidrestapi.common.controller.PageableRequest;
import engineeringthesis.androidrestapi.common.controller.UuidDto;
import engineeringthesis.androidrestapi.game.GameFacade;
import engineeringthesis.androidrestapi.game.dto.CreateGameForm;
import engineeringthesis.androidrestapi.game.dto.GameDto;
import engineeringthesis.androidrestapi.game.dto.GameFilterForm;
import engineeringthesis.androidrestapi.game.dto.UpdateGameForm;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static engineeringthesis.androidrestapi.game.controller.GameController.Routes.ROOT;
import static engineeringthesis.androidrestapi.game.controller.GameController.Routes.ROOT_UUID;

@RestController
@RequiredArgsConstructor
class GameController {

    private final GameFacade gameFacade;

    static final class Routes {
        static final String ROOT = "/games";
        static final String ROOT_UUID = ROOT + "/{uuid}";
    }

    @GetMapping(ROOT)
    PageDto<GameDto> findGames(@RequestBody final GameFilterForm filterForm, final PageableRequest pageableRequest) {
        return gameFacade.findGames(filterForm, pageableRequest);
    }

    @GetMapping(ROOT_UUID)
    GameDto findGame(@PathVariable final UUID uuid) {
        return gameFacade.findGame(uuid);
    }

    @PostMapping(ROOT)
    @ResponseStatus(HttpStatus.CREATED)
    UuidDto saveGame(@RequestBody final CreateGameForm gameForm) {
        return gameFacade.saveGame(gameForm);
    }

    @PutMapping(ROOT_UUID)
    void updateGame(@PathVariable final UUID uuid, @RequestBody final UpdateGameForm gameForm) {
        gameFacade.updateGame(uuid, gameForm);
    }

    @DeleteMapping(ROOT_UUID)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteGame(@PathVariable final UUID uuid) {
        gameFacade.deleteGame(uuid);
    }
}

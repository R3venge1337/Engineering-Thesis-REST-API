package engineeringthesis.androidrestapi.game.controller;

import engineeringthesis.androidrestapi.common.controller.PageDto;
import engineeringthesis.androidrestapi.common.controller.PageableRequest;
import engineeringthesis.androidrestapi.common.controller.UuidDto;
import engineeringthesis.androidrestapi.game.GameplayFacade;
import engineeringthesis.androidrestapi.game.dto.CreateGameplayForm;
import engineeringthesis.androidrestapi.game.dto.GameplayDto;
import engineeringthesis.androidrestapi.game.dto.GameplayFilterForm;
import engineeringthesis.androidrestapi.game.dto.UpdateGameplayForm;
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

import static engineeringthesis.androidrestapi.game.controller.GameplayController.Routes.ROOT;
import static engineeringthesis.androidrestapi.game.controller.GameplayController.Routes.ROOT_UUID;

@RestController
@RequiredArgsConstructor
class GameplayController {

    private final GameplayFacade gameplayFacade;

    static final class Routes {
        static final String ROOT = "/matches";
        static final String ROOT_UUID = ROOT + "/{uuid}";
    }


    @GetMapping(ROOT)
    PageDto<GameplayDto> findGameplays(@RequestBody final GameplayFilterForm filterForm, final PageableRequest pageableRequest) {
        return gameplayFacade.findGameplays(filterForm, pageableRequest);
    }

    @GetMapping(ROOT_UUID)
    GameplayDto findGameplay(@PathVariable final UUID uuid) {
        return gameplayFacade.findGameplay(uuid);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    UuidDto saveGameplay(@RequestBody final CreateGameplayForm gameplayForm) {
        return gameplayFacade.saveGameplay(gameplayForm);
    }

    @PutMapping(ROOT_UUID)
    void updateGameplay(@PathVariable final UUID uuid, @RequestBody final UpdateGameplayForm gameplayForm) {
        gameplayFacade.updateGameplay(uuid, gameplayForm);
    }

    @DeleteMapping(ROOT_UUID)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteGameplay(@PathVariable final UUID uuid) {
        gameplayFacade.deleteGameplay(uuid);
    }
}
package engineeringthesis.androidrestapi.game.controller;

import engineeringthesis.androidrestapi.common.controller.PageDto;
import engineeringthesis.androidrestapi.common.controller.PageableRequest;
import engineeringthesis.androidrestapi.common.controller.UuidDto;
import engineeringthesis.androidrestapi.game.GameplayResultFacade;
import engineeringthesis.androidrestapi.game.domain.GameplayResultFilterForm;
import engineeringthesis.androidrestapi.game.dto.CreateGameplayResultForm;
import engineeringthesis.androidrestapi.game.dto.GameplayResultDto;
import engineeringthesis.androidrestapi.game.dto.UpdateGameplayResultForm;
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

import java.util.List;
import java.util.UUID;

import static engineeringthesis.androidrestapi.game.controller.GameplayResultController.Routes.ROOT;
import static engineeringthesis.androidrestapi.game.controller.GameplayResultController.Routes.ROOT_CHILD;
import static engineeringthesis.androidrestapi.game.controller.GameplayResultController.Routes.ROOT_GAME;
import static engineeringthesis.androidrestapi.game.controller.GameplayResultController.Routes.ROOT_GAMEPLAY_UUID;

@RestController
@RequiredArgsConstructor
class GameplayResultController {

    private final GameplayResultFacade gameplayResultFacade;

    static final class Routes {
        static final String ROOT = "/results";
        static final String ROOT_UUID = ROOT + "/{uuid}";
        static final String ROOT_GAMEPLAY_UUID = ROOT + "/gameplay/{uuid}";
        static final String ROOT_CHILD = ROOT + "/child/{guestUUID}";
        static final String ROOT_GAME = ROOT + "/game/{gameName}";
    }

    @GetMapping(ROOT)
    PageDto<GameplayResultDto> findGameplayResults(@RequestBody final GameplayResultFilterForm filterForm, final PageableRequest pageableRequest) {
        return gameplayResultFacade.findGameplayResults(filterForm, pageableRequest);
    }


    @GetMapping(ROOT_GAMEPLAY_UUID)
    PageDto<GameplayResultDto> getAllGameplayResultsByGameplayId(@PathVariable final UUID uuid) {
        return gameplayResultFacade.getAllGameplayResultsByGameplayId(uuid);
    }

    @PostMapping(ROOT)
    @ResponseStatus(HttpStatus.CREATED)
    UuidDto saveGameplay(@RequestBody final CreateGameplayResultForm resultForm) {
        return gameplayResultFacade.saveGameplayResults(resultForm);
    }

    @PutMapping(ROOT)
    void updateGameplayResults(@PathVariable final UUID uuid, @RequestBody final UpdateGameplayResultForm resultForm) {
        gameplayResultFacade.updateGameplayResults(uuid, resultForm);
    }

    @DeleteMapping(ROOT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteGameplayResultsById(@PathVariable final UUID uuid) {
        gameplayResultFacade.deleteGameplayResults(uuid);
    }

    @GetMapping(ROOT_CHILD)
    List<GameplayResultDto> getAllUserResultsByGuestId(@PathVariable final String guestUUID) {
        return gameplayResultFacade.getAllUserResultsByGuestId(guestUUID);
    }

    @GetMapping(ROOT_GAME)
    List<GameplayResultDto> getAllGameplayResultsByGameName(@PathVariable final String gameName) {
        return gameplayResultFacade.getAllUserResultsByGameName(gameName);
    }

}

package engineeringthesis.androidrestapi.game.controller;

import engineeringthesis.androidrestapi.game.GameplayResultFacade;
import engineeringthesis.androidrestapi.game.dto.CreateGameplayResultForm;
import engineeringthesis.androidrestapi.game.dto.GameplayResultDto;
import engineeringthesis.androidrestapi.game.dto.UpdateGameplayResultForm;
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
@RequestMapping(value = "/api/results")
@RequiredArgsConstructor
class GameplayResultController {

    private final GameplayResultFacade gameplayResultFacade;

    @GetMapping
    List<GameplayResultDto> getAllGameplayResults() {
        return gameplayResultFacade.getAllGameplayResults();
    }


    @GetMapping(value = "/gameplay/{uuid}")
    List<GameplayResultDto> getAllGameplayResultsByGameplayId(@PathVariable final UUID uuid) {
        return gameplayResultFacade.getAllGameplayResultsByGameplayId(uuid);
    }

    @PostMapping
    GameplayResultDto saveGameplay(@RequestBody final CreateGameplayResultForm resultForm) {
        return gameplayResultFacade.saveGameplayResults(resultForm);
    }

    @PutMapping(value = "/{uuid}")
    void updateGameplayResults(@PathVariable final UUID uuid, @RequestBody final UpdateGameplayResultForm resultForm) {
        gameplayResultFacade.updateGameplayResults(uuid, resultForm);
    }

    @DeleteMapping
    void deleteGameplayResultsById(@PathVariable final UUID uuid) {
        gameplayResultFacade.deleteGameplayResults(uuid);
    }

    @GetMapping(value = "/child/{guestUUID}")
    List<GameplayResultDto> getAllUserResultsByGuestId(@PathVariable final String guestUUID) {
        return gameplayResultFacade.getAllUserResultsByGuestId(guestUUID);
    }

    @GetMapping(value = "/game/{gameName}")
    List<GameplayResultDto> getAllGameplayResultsByGameName(@PathVariable final String gameName) {
        return gameplayResultFacade.getAllUserResultsByGameName(gameName);
    }

}

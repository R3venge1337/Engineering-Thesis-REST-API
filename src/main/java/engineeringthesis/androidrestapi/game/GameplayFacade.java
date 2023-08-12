package engineeringthesis.androidrestapi.game;

import engineeringthesis.androidrestapi.common.controller.PageDto;
import engineeringthesis.androidrestapi.common.controller.PageableRequest;
import engineeringthesis.androidrestapi.common.controller.UuidDto;
import engineeringthesis.androidrestapi.game.dto.CreateGameplayForm;
import engineeringthesis.androidrestapi.game.dto.GameplayDto;
import engineeringthesis.androidrestapi.game.dto.GameplayFilterForm;
import engineeringthesis.androidrestapi.game.dto.UpdateGameplayForm;

import java.util.UUID;


public interface GameplayFacade {

    PageDto<GameplayDto> findGameplays(final GameplayFilterForm filterForm, final PageableRequest pageableRequest);

    UuidDto saveGameplay(final CreateGameplayForm gameplayForm);

    GameplayDto findGameplay(final UUID uuid);

    void updateGameplay(final UUID uuid, final UpdateGameplayForm gameplayForm);

    void deleteGameplay(final UUID uuid);
}

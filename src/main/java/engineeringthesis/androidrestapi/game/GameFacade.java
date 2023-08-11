package engineeringthesis.androidrestapi.game;

import engineeringthesis.androidrestapi.common.controller.PageDto;
import engineeringthesis.androidrestapi.common.controller.PageableRequest;
import engineeringthesis.androidrestapi.common.controller.UuidDto;
import engineeringthesis.androidrestapi.game.dto.CreateGameForm;
import engineeringthesis.androidrestapi.game.dto.GameDto;
import engineeringthesis.androidrestapi.game.dto.GameFilterForm;
import engineeringthesis.androidrestapi.game.dto.UpdateGameForm;

import java.util.UUID;

public interface GameFacade {

    PageDto<GameDto> findGames(final GameFilterForm filterForm, final PageableRequest pageableRequest);

    UuidDto saveGame(final CreateGameForm gameForm);

    GameDto findGame(final UUID uuid);

    void updateGame(final UUID uuid, final UpdateGameForm gameForm);

    void deleteGame(final UUID uuid);
}

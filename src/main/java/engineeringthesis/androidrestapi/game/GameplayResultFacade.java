package engineeringthesis.androidrestapi.game;

import engineeringthesis.androidrestapi.common.controller.PageDto;
import engineeringthesis.androidrestapi.common.controller.PageableRequest;
import engineeringthesis.androidrestapi.common.controller.UuidDto;
import engineeringthesis.androidrestapi.game.domain.GameplayResultFilterForm;
import engineeringthesis.androidrestapi.game.dto.CreateGameplayResultForm;
import engineeringthesis.androidrestapi.game.dto.GameplayResultDto;
import engineeringthesis.androidrestapi.game.dto.UpdateGameplayResultForm;

import java.util.List;
import java.util.UUID;

public interface GameplayResultFacade {

    PageDto<GameplayResultDto> findGameplayResults(final GameplayResultFilterForm filterForm, final PageableRequest pageableRequest);

    PageDto<GameplayResultDto> getAllGameplayResultsByGameplayId(final UUID uuid);

    List<GameplayResultDto> getAllUserResultsByGuestId(final String guestUUID);

    List<GameplayResultDto> getAllUserResultsByGameName(final String gameName);

    UuidDto saveGameplayResults(final CreateGameplayResultForm resultForm);

    void updateGameplayResults(final UUID uuid, final UpdateGameplayResultForm resultForm);

    void deleteGameplayResults(final UUID uuid);


}

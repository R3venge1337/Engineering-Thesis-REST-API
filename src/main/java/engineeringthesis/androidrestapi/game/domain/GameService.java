package engineeringthesis.androidrestapi.game.domain;

import engineeringthesis.androidrestapi.common.controller.PageDto;
import engineeringthesis.androidrestapi.common.controller.PageableRequest;
import engineeringthesis.androidrestapi.common.controller.PageableUtils;
import engineeringthesis.androidrestapi.common.controller.UuidDto;
import engineeringthesis.androidrestapi.common.exception.NotFoundException;
import engineeringthesis.androidrestapi.common.exception.NotUniqueException;
import engineeringthesis.androidrestapi.common.validation.DtoValidator;
import engineeringthesis.androidrestapi.game.GameFacade;
import engineeringthesis.androidrestapi.game.dto.CreateGameForm;
import engineeringthesis.androidrestapi.game.dto.GameDto;
import engineeringthesis.androidrestapi.game.dto.GameFilterForm;
import engineeringthesis.androidrestapi.game.dto.UpdateGameForm;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.UUID;

import static engineeringthesis.androidrestapi.game.domain.GameService.ErrorMessages.GAME_FOUND;
import static engineeringthesis.androidrestapi.game.domain.GameService.ErrorMessages.GAME_NOT_EXIST;

@RequiredArgsConstructor
class GameService implements GameFacade {

    private final GameRepository gameRepository;

    static final class ErrorMessages {
        static final String GAME_NOT_EXIST = "Game not exist";
        static final String GAME_FOUND = "Game was found";
    }

    @Override
    public PageDto<GameDto> findGames(final GameFilterForm filterForm, final PageableRequest pageableRequest) {
        DtoValidator.validate(filterForm);
        DtoValidator.validate(pageableRequest);

        final GameSpecification gameSpecification = new GameSpecification(filterForm);
        final Page<GameDto> games = gameRepository.findAll(gameSpecification, PageableUtils.createPageable(pageableRequest))
                .map(this::mapToDto);

        return PageableUtils.toDto(games);
    }

    @Override
    public GameDto findGame(final UUID uuid) {
        return gameRepository.findByUuid(uuid)
                .map(this::mapToDto)
                .orElseThrow(() -> new NotFoundException(GAME_NOT_EXIST));
    }

    @Override
    @Transactional
    public UuidDto saveGame(final CreateGameForm createForm) {
        DtoValidator.validate(createForm);
        checkUnique(createForm.name());


        Game game = new Game();
        game.setName(createForm.name());

        return new UuidDto(gameRepository.save(game).getUuid());
    }


    @Override
    @Transactional
    public void updateGame(final UUID uuid, final UpdateGameForm updateForm) {
        DtoValidator.validate(updateForm);

        final Game game = gameRepository.findByUuid(uuid)
                .orElseThrow(() -> new NotFoundException(GAME_NOT_EXIST));

        checkUnique(updateForm.name(), game.getName());

        game.setName(updateForm.name());
    }

    @Override
    @Transactional
    public void deleteGame(final UUID uuid) {
        gameRepository.deleteByUuid(uuid);
    }

    GameDto mapToDto(final Game game) {
        return new GameDto(game.getUuid(), game.getName());
    }

    private void checkUnique(final String formName, final String entityName) {
        if (!formName.equals(entityName)) {
            checkUnique(formName);
        }
    }

    void checkUnique(final String name) {
        if (gameRepository.existsByName(name)) {
            throw new NotUniqueException(Game.Fields.name, GAME_FOUND);
        }
    }
}

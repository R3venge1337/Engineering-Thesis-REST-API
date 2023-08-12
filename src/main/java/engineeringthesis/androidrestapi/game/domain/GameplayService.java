package engineeringthesis.androidrestapi.game.domain;

import engineeringthesis.androidrestapi.common.controller.PageDto;
import engineeringthesis.androidrestapi.common.controller.PageableRequest;
import engineeringthesis.androidrestapi.common.controller.PageableUtils;
import engineeringthesis.androidrestapi.common.controller.UuidDto;
import engineeringthesis.androidrestapi.common.exception.NotFoundException;
import engineeringthesis.androidrestapi.common.validation.DtoValidator;
import engineeringthesis.androidrestapi.game.GameplayFacade;
import engineeringthesis.androidrestapi.game.dto.CreateGameplayForm;
import engineeringthesis.androidrestapi.game.dto.GameplayDto;
import engineeringthesis.androidrestapi.game.dto.GameplayFilterForm;
import engineeringthesis.androidrestapi.game.dto.UpdateGameplayForm;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.UUID;

import static engineeringthesis.androidrestapi.game.domain.GameplayService.ErrorMessages.GAMEPLAY_NOT_EXIST;

@RequiredArgsConstructor
class GameplayService implements GameplayFacade {

    private final GameplayRepository gameplayRepository;

    static final class ErrorMessages {
        static final String GAMEPLAY_NOT_EXIST = "Gameplay not exist";
        static final String GAMEPLAY_FOUND = "Gameplay was found";
    }

    @Override
    public PageDto<GameplayDto> findGameplays(final GameplayFilterForm filterForm, final PageableRequest pageableRequest) {
        DtoValidator.validate(filterForm);
        DtoValidator.validate(pageableRequest);

        final GameplaySpecification gameplaySpecification = new GameplaySpecification(filterForm);
        final Page<GameplayDto> gameplays = gameplayRepository.findAll(gameplaySpecification, PageableUtils.createPageable(pageableRequest))
                .map(this::mapToDto);

        return PageableUtils.toDto(gameplays);
    }

    @Override
    @Transactional
    public UuidDto saveGameplay(final CreateGameplayForm createForm) {
        DtoValidator.validate(createForm);

        Gameplay gameplay = new Gameplay();


        return new UuidDto(gameplayRepository.save(gameplay).getUuid());
    }

    @Override
    public GameplayDto findGameplay(final UUID uuid) {
        return gameplayRepository.findByUuid(uuid)
                .map(this::mapToDto)
                .orElseThrow(() -> new NotFoundException(GAMEPLAY_NOT_EXIST));
    }

    @Override
    @Transactional
    public void updateGameplay(final UUID uuid, final UpdateGameplayForm updateForm) {
        DtoValidator.validate(updateForm);

        final Gameplay gameplay = gameplayRepository.findByUuid(uuid)
                .orElseThrow(() -> new NotFoundException(GAMEPLAY_NOT_EXIST));
		/*
		gameplay.setGameMatchDataStart(gameplayForm.getGameMatchDataStart());
		gameplay.setGameMatchDataEnd(gameplayForm.getGameMatchDataEnd());
		 */
    }

    @Override
    @Transactional
    public void deleteGameplay(final UUID uuid) {
        gameplayRepository.deleteByUuid(uuid);
    }

    GameplayDto mapToDto(final Gameplay gameplay) {
        return new GameplayDto(null, null, null, null, null, gameplay.getStartDate(), gameplay.getEndDate());
    }
}

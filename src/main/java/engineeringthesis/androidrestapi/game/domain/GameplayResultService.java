package engineeringthesis.androidrestapi.game.domain;

import engineeringthesis.androidrestapi.common.controller.PageDto;
import engineeringthesis.androidrestapi.common.controller.PageableRequest;
import engineeringthesis.androidrestapi.common.controller.PageableUtils;
import engineeringthesis.androidrestapi.common.controller.UuidDto;
import engineeringthesis.androidrestapi.common.exception.NotFoundException;
import engineeringthesis.androidrestapi.common.validation.DtoValidator;
import engineeringthesis.androidrestapi.game.GameplayResultFacade;
import engineeringthesis.androidrestapi.game.dto.CreateGameplayResultForm;
import engineeringthesis.androidrestapi.game.dto.GameplayResultDto;
import engineeringthesis.androidrestapi.game.dto.UpdateGameplayResultForm;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

import static engineeringthesis.androidrestapi.game.domain.GameplayResultService.ErrorMessages.GAMEPLAY_RESULT_NOT_EXIST;

@RequiredArgsConstructor
class GameplayResultService implements GameplayResultFacade {


    private final GameplayResultsRepository gameplayResultsRepository;

    static final class ErrorMessages {
        static final String GAMEPLAY_RESULT_NOT_EXIST = "Gameplay results not exist";
        static final String GAMEPLAY_RESULT_FOUND = "Gameplay results was found";
    }

    @Override
    public PageDto<GameplayResultDto> findGameplayResults(final GameplayResultFilterForm filterForm, final PageableRequest pageableRequest) {
        DtoValidator.validate(filterForm);
        DtoValidator.validate(pageableRequest);

        final GameplayResultSpecification specification = new GameplayResultSpecification(filterForm);
        final Page<GameplayResultDto> results = gameplayResultsRepository.findAll(specification, PageableUtils.createPageable(pageableRequest))
                .map(this::mapToDto);

        return PageableUtils.toDto(results);
    }

    @Override
    @Transactional
    public UuidDto saveGameplayResults(final CreateGameplayResultForm createForm) {
        DtoValidator.validate(createForm);

        final GameplayResult gameplayResult = new GameplayResult();

        return new UuidDto(gameplayResultsRepository.save(gameplayResult).getUuid());
    }

    @Override
    public PageDto<GameplayResultDto> getAllGameplayResultsByGameplayId(final UUID uuid) {
        final Page<GameplayResultDto> results = gameplayResultsRepository.findByGameplayUuid(uuid)
                .map(this::mapToDto);

        return PageableUtils.toDto(results);
    }

    @Override
    @Transactional
    public void updateGameplayResults(final UUID uuid, final UpdateGameplayResultForm updateForm) {
        DtoValidator.validate(updateForm);

        final GameplayResult gameplayResult = gameplayResultsRepository.findByUuid(uuid)
                .orElseThrow(() -> new NotFoundException(GAMEPLAY_RESULT_NOT_EXIST));
    }

    @Override
    @Transactional
    public void deleteGameplayResults(final UUID uuid) {
        gameplayResultsRepository.deleteByUuid(uuid);
    }

    @Override
    public List<GameplayResultDto> getAllUserResultsByGuestId(final String guestUUID) {
        return gameplayResultsRepository.getAllUserResultsByGuestId(guestUUID).stream()
                .map(this::mapToDto)
                .toList();
    }

    @Override
    public List<GameplayResultDto> getAllUserResultsByGameName(final String gameName) {

        return gameplayResultsRepository.getAllUserResultsByGameName(gameName).stream()
                .map(this::mapToDto).toList();
    }

    GameplayResultDto mapToDto(final GameplayResult result) {
        return new GameplayResultDto(result.getUuid(), null, null);
    }
}

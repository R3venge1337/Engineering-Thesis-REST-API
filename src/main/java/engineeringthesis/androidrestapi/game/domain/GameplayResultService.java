package engineeringthesis.androidrestapi.game.domain;

import engineeringthesis.androidrestapi.common.exception.NotFoundException;
import engineeringthesis.androidrestapi.game.GameplayResultFacade;
import engineeringthesis.androidrestapi.game.dto.CreateGameplayResultForm;
import engineeringthesis.androidrestapi.game.dto.GameplayResultDto;
import engineeringthesis.androidrestapi.game.dto.UpdateGameplayResultForm;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
class GameplayResultService implements GameplayResultFacade {


    private final GameplayResultsRepository gameplayResultsRepository;

    @Override
    public List<GameplayResultDto> getAllGameplayResults() {
        return gameplayResultsRepository.findAll().stream()
                .map(this::mapToDto)
                .toList();
    }

    @Override
    @Transactional
    public GameplayResultDto saveGameplayResults(final CreateGameplayResultForm resultForm) {

        GameplayResult gameplayResult = new GameplayResult();

        return mapToDto(gameplayResultsRepository.save(gameplayResult));
    }

    @Override
    public List<GameplayResultDto> getAllGameplayResultsByGameplayId(final UUID uuid) {
        return gameplayResultsRepository.findByGameplayUuid(uuid).stream()
                .map(this::mapToDto)
                .toList();
    }

    @Override
    @Transactional
    public void updateGameplayResults(final UUID uuid, final UpdateGameplayResultForm resultForm) {
        GameplayResult gameplayResult = gameplayResultsRepository.findByUuid(uuid)
                .orElseThrow(() -> new NotFoundException(""));
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
        return new GameplayResultDto(result.getUuid(),null,null);
    }
}

package engineeringthesis.androidrestapi.game.domain;

import engineeringthesis.androidrestapi.common.exception.NotFoundException;
import engineeringthesis.androidrestapi.game.GameplayFacade;
import engineeringthesis.androidrestapi.game.dto.CreateGameplayForm;
import engineeringthesis.androidrestapi.game.dto.GameplayDto;
import engineeringthesis.androidrestapi.game.dto.UpdateGameplayForm;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
class GameplayService implements GameplayFacade {

    private final GameplayRepository gameplayRepository;

    @Override
    public List<GameplayDto> getAllGameplay() {
        return gameplayRepository.findAll().stream()
                .map(this::mapToDto)
                .toList();
    }

    @Override
    @Transactional
    public GameplayDto saveGameplay(final CreateGameplayForm gameplayForm) {
        Gameplay gameplay = new Gameplay();

        return mapToDto(gameplayRepository.save(gameplay));
    }

    @Override
    public GameplayDto findGameplay(final UUID uuid) {
        return gameplayRepository.findByUuid(uuid)
                .map(this::mapToDto)
                .orElseThrow(() -> new NotFoundException(""));
    }

    @Override
    @Transactional
    public void updateGameplay(final UUID uuid, final UpdateGameplayForm gameplayForm) {
        Gameplay gameplay = gameplayRepository.findByUuid(uuid)
                .orElseThrow(() -> new NotFoundException(""));
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
        return new GameplayDto(null, null, null,null,null, gameplay.getStartDate(), gameplay.getEndDate());
    }
}

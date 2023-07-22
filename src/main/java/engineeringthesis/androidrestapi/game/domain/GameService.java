package engineeringthesis.androidrestapi.game.domain;

import engineeringthesis.androidrestapi.common.exception.NotFoundException;
import engineeringthesis.androidrestapi.game.GameFacade;
import engineeringthesis.androidrestapi.game.dto.CreateGameForm;
import engineeringthesis.androidrestapi.game.dto.GameDto;
import engineeringthesis.androidrestapi.game.dto.UpdateGameForm;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
class GameService implements GameFacade {

    private final GameRepository gameRepository;

    @Override
    public List<GameDto> getAllGames() {
        return gameRepository.findAll().stream()
                .map(this::mapToDto)
                .toList();
    }

    @Override
    public GameDto findGame(final UUID uuid) {
        return gameRepository.findByUuid(uuid)
                .map(this::mapToDto)
                .orElseThrow(() -> new NotFoundException(""));
    }

    @Override
    @Transactional
    public GameDto saveGame(final CreateGameForm gameForm) {

        Game game = new Game();
        game.setName(gameForm.name());

        return mapToDto(gameRepository.save(game));
    }


    @Override
    @Transactional
    public void updateGame(final UUID uuid, final UpdateGameForm gameForm) {
        final Game game = gameRepository.findByUuid(uuid)
                .orElseThrow(() -> new NotFoundException(""));

        game.setName(gameForm.name());
    }

    @Override
    @Transactional
    public void deleteGame(final UUID uuid) {
        gameRepository.deleteByUuid(uuid);
    }

    GameDto mapToDto(final Game game) {
        return new GameDto(game.getUuid(), game.getName());
    }
}

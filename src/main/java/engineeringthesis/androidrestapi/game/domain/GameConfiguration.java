package engineeringthesis.androidrestapi.game.domain;

import engineeringthesis.androidrestapi.game.GameFacade;
import engineeringthesis.androidrestapi.game.GameplayFacade;
import engineeringthesis.androidrestapi.game.GameplayResultFacade;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class GameConfiguration {

    @Bean
    GameFacade gameFacade(final GameRepository gameRepository) {
        return new GameService(gameRepository);
    }

    @Bean
    GameplayFacade gameplayFacade(final GameplayRepository gameplayRepository) {
        return new GameplayService(gameplayRepository);
    }

    @Bean
    GameplayResultFacade gameplayResultFacade(final GameplayResultsRepository gameplayResultsRepository) {
        return new GameplayResultService(gameplayResultsRepository);
    }
}

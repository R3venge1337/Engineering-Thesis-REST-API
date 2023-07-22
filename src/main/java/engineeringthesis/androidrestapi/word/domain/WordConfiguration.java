package engineeringthesis.androidrestapi.word.domain;

import engineeringthesis.androidrestapi.word.WordFacade;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class WordConfiguration {

    @Bean
    WordFacade wordFacade(final WordRepository wordRepository){
        return new WordService(wordRepository);
    }
}

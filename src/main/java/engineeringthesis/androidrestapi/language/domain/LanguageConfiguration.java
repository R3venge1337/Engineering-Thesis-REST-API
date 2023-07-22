package engineeringthesis.androidrestapi.language.domain;

import engineeringthesis.androidrestapi.language.LanguageFacade;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LanguageConfiguration {

    @Bean
    LanguageFacade languageFacade(final LanguageRepository languageRepository){
        return new LanguageService(languageRepository);
    }
}

package engineeringthesis.androidrestapi.child.domain;

import engineeringthesis.androidrestapi.child.ChildFacade;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class ChildConfiguration {

    @Bean
    ChildFacade childFacade(final ChildRepository childRepository) {
        return new ChildService(childRepository);
    }
}

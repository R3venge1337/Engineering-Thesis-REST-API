package engineeringthesis.androidrestapi.child.domain;

import engineeringthesis.androidrestapi.child.ChildFacade;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
class ChildConfiguration {

    @Bean
    ChildFacade childFacade(final ChildRepository childRepository, final ChildAccountRepository accountRepository,
                            final ChildRoleRepository roleRepository, final PasswordEncoder passwordEncoder) {
        return new ChildService(childRepository, accountRepository, roleRepository, passwordEncoder);
    }
}

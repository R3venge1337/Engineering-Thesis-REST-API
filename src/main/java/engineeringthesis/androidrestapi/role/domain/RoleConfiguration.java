package engineeringthesis.androidrestapi.role.domain;

import engineeringthesis.androidrestapi.role.RoleFacade;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class RoleConfiguration {

    @Bean
    RoleFacade roleFacade(final RoleRepository roleRepository){
        return new RoleService(roleRepository);
    }
}

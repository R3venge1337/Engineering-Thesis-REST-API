package engineeringthesis.androidrestapi.account.domain;

import engineeringthesis.androidrestapi.account.AccountFacade;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
class AccountConfiguration {

    @Bean
    AccountFacade accountFacade(final AccountRepository accountRepository, final AccountRoleRepository accountRoleRepository, final PasswordEncoder passwordEncoder) {
        return new AccountService(accountRepository, accountRoleRepository, passwordEncoder);
    }
}

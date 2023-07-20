package engineeringthesis.androidrestapi.security.domain;

import engineeringthesis.androidrestapi.account.AccountFacade;
import engineeringthesis.androidrestapi.account.dto.AccountDto;
import engineeringthesis.androidrestapi.security.AuthenticationFacade;
import engineeringthesis.androidrestapi.security.PasswordFacade;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
class AuthenticationConfiguration {

  @Value("${jwt.secret.key}")
  private String jwtSecretKey;

  @Bean
  UserDetailsService userDetailsService(final AccountFacade accountFacade) {
    return username -> {
      final AccountDto dto = accountFacade.findAccount(username);
      return new AuthorizationUser(dto);
    };
  }

  @Bean
  AuthenticationProvider authenticationProvider(final AccountFacade accountFacade) {
    final DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
    daoAuthenticationProvider.setUserDetailsService(userDetailsService(accountFacade));
    daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
    return daoAuthenticationProvider;
  }

  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  AuthenticationManager authenticationManager(final org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration authenticationConfiguration) throws Exception {
    return authenticationConfiguration.getAuthenticationManager();
  }

  @Bean
  JwtUtils jwtUtils() {
    return new JwtUtils(jwtSecretKey);
  }

  @Bean
  AuthenticationFacade authenticationFacade(final AccountFacade accountFacade, final JwtUtils jwtUtils, final AuthenticationManager authenticationManager) {
    return new AuthenticationService(accountFacade, jwtUtils, authenticationManager);
  }

  @Bean
  PasswordFacade passwordFacade(final PasswordEncoder passwordEncoder) {
    return new PasswordService(passwordEncoder);
  }

  @Bean
  JwtAuthenticationFilter jwtAuthenticationFilter(){
    return new JwtAuthenticationFilter(jwtUtils());
  }
}

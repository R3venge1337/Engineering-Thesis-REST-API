package engineeringthesis.androidrestapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import engineeringthesis.androidrestapi.auth.JwtRequestFilter;
import engineeringthesis.androidrestapi.auth.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, jsr250Enabled = true, prePostEnabled = true)
@RequiredArgsConstructor
class SecurityConfiguration {

	private final UserDetailsServiceImpl userDetailsService;

	private final JwtRequestFilter jwtRequestFilter;

	private static final String[] AUTH_WHITELIST = {
			// -- Swagger UI v2
			"/v2/api-docs", "/swagger-resources", "/swagger-resources/**", "/configuration/ui",
			"/configuration/security", "/swagger-ui.html", "/authenticate", "/swagger-resources/**", "/swagger-ui/**",
			"/v3/api-docs", "/webjars/**",
			// -- Swagger UI v3 (OpenAPI)
			"/v3/api-docs/**", "/api/login", "/api/authenticate", "/api/token", "/swagger-ui.html/", "/api/swagger-ui/"
			// other public endpoints of your API may be appended to this array
	};

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
			throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}

	@Bean
	AuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(passwordEncoder());
		provider.setUserDetailsService(userDetailsService);
		return provider;
	}

	@Bean
	AuthenticationManager configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(new BCryptPasswordEncoder());
		provider.setUserDetailsService(userDetailsService);
		auth.authenticationProvider(provider);
		return auth.getOrBuild();
	}

	@Bean
	protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		// We don't need CSRF for this example
		/*
		 * http.csrf().disable() // dont authenticate this particular request
		 * .authorizeRequests() .antMatchers("/swagger-ui.html/**", "/configuration/**",
		 * "/swagger-resources/**",
		 * "/v2/api-docs","/webjars/**","/api/login","/api/accounts/**","/api/accounts",
		 * "/api/roles","/api/roles/**","/api/teachers","/api/teachers/**"
		 * ,"/api/children","/api/children/**","/api/languages","/api/languages/**",
		 * "/api/games","/api/games/**","/api/categories","/api/categories/**"
		 * ,"/api/words","/api/words/**","/api/images","/api/images/**"
		 * ,"/api/audio","/api/audio/**","/api/authenticate","/api/teachers/accounts"
		 * ,"/api/children/accounts","/api/children/accounts/**",
		 * "/api/teachers/accounts/**","/api/token","/api/authenticate"
		 * ,"/api/statistics","/api/statistics/**","/api/matches","/api/matches/**",
		 * "/api/statistics/statisticResults","/api/statistics/statisticResults/**",
		 * "/api/results","/api/results/**").permitAll() .anyRequest().authenticated()
		 * .and()
		 * .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		 * .and() .exceptionHandling() .authenticationEntryPoint(new
		 * HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED));
		 * 
		 */
		http.cors().and().csrf().disable().headers().frameOptions().deny().and()
				// dont authenticate this particular request
				.authorizeRequests().antMatchers(AUTH_WHITELIST).permitAll().
				// all other requests need to be authenticated
				anyRequest().authenticated().and().
				// make sure we use stateless session; session won't be // used to store user's
				// state.
				exceptionHandling().authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)).and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
// Add a filter to validate the tokens with every request
		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
		return http.build();

	}

}

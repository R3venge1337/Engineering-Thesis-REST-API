package engineeringthesis.androidrestapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import engineeringthesis.androidrestapi.util.JwtRequestFilter;
import engineeringthesis.androidrestapi.util.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	private final UserDetailsServiceImpl userDetailsService;
	
	private final JwtRequestFilter jwtRequestFilter;
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		 auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		// We don't need CSRF for this example
		httpSecurity.csrf().disable()
				// dont authenticate this particular request
				.authorizeRequests()
				.antMatchers(HttpMethod.GET,"/swagger-ui.html/**", "/configuration/**", "/swagger-resources/**", "/v2/api-docs","/webjars/**","/api/login","/api/accounts/**","/api/accounts","/api/roles","/api/roles/**","/api/teachers","/api/teachers/**"
						,"/api/children","/api/children/**","/api/languages","/api/languages/**","/api/games","/api/games/**","/api/categories","/api/categories/**"
						,"/api/words","/api/words/**","/api/images","/api/images/**"
						,"/api/audio","/api/audio/**","/api/authenticate","/api/teachers/accounts"
						,"/api/children/accounts","/api/children/accounts/**","/api/teachers/accounts/**"
						,"/api/statistics","/api/statistics/**","/api/matches","/api/matches/**","/api/statistics/statisticResults","/api/statistics/statisticResults/**","/api/results","/api/results/**").permitAll()
				.antMatchers(HttpMethod.GET, "/api/token").hasAnyRole("nauczyciel","administrator","dziecko")
				.antMatchers(HttpMethod.PUT,"/api/accounts/{accountId}","/api/words/{audioId}").hasAnyRole("nauczyciel","administrator","dziecko")
				.antMatchers(HttpMethod.PUT,"/api/audio/{audioId}","/api/categories/{categoryId}","/api/games/{gameId}","/api/matches/{gameplayId}","/api/results/{gameplayId}"
						,"/api/images/{imageId}","/api/languages/{languageId}","/api/statistics/statisticResults/{statisticResultsId}","/api/statistics/{statisticId}","/api/teachers/{teacherId}","/api/words/{wordId}").hasAnyRole("nauczyciel","administrator")
				.antMatchers(HttpMethod.PUT,"/api/children/{childId}").hasAnyRole("dziecko")
				.antMatchers(HttpMethod.POST,"/api/accounts/","/api/authenticate","/api/children","/api/matches","/api/results","/api/languages","/api/statistics/statisticResults").permitAll()
				.antMatchers(HttpMethod.POST,"/api/audio","/api/categories","/api/words","/api/categories/teachers","/api/games","/api/images","/api/statistics","/api/words").hasAnyRole("administrator","nauczyciel")
				.antMatchers(HttpMethod.POST,"/api/roles","/api/teachers").hasRole("administrator")
				.antMatchers(HttpMethod.DELETE,"/api/accounts/{accountId}","/api/words/{audioId}","/api/audio/{audioId}"
						,"/api/categories/{categoryId}","/api/games/{gameId}","/api/matches/{gameMatchId}","/api/results","/api/images/{imageId}","/api/languages/{languageId}","/api/roles","/api/statistics/statisticResults/{statisticResultsId}","/api/statistics/{statisticId}","/api/teachers/{teacherId}","/api/words/{wordId}").hasRole("administrator")
				.antMatchers(HttpMethod.DELETE,"/api/children/{childId}").hasRole("dziecko")
				.anyRequest().authenticated()
				.and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.exceptionHandling()
				.authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED));
		
		httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
				
	}
	
	
	
}


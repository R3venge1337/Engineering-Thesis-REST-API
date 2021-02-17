package engineeringthesis.androidrestapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
				.antMatchers("/swagger-ui.html/**", "/configuration/**", "/swagger-resources/**", "/v2/api-docs","/webjars/**","/api/login","/api/accounts/**","/api/accounts","/api/roles","/api/roles/**","/api/teachers","/api/teachers/**"
						,"/api/children","/api/children/**","/api/languages","/api/languages/**","/api/authenticate","/api/token","/api/games","/api/games/**","/api/categories","/api/categories/**"
						,"/api/words","/api/words/**","/api/images","/api/images/**"
						,"/api/audio","/api/audio/**","/api/authenticate","/api/teachers/accounts"
						,"/api/children/accounts","/api/children/accounts/**","/api/teachers/accounts/**"
						,"/api/statistics","/api/statistics/**","/api/matches","/api/matches/**","/api/statistics/statisticResults","/api/statistics/statisticResults/**","/api/results","/api/results/**").permitAll()
				.anyRequest().authenticated()
				.and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.exceptionHandling()
				.authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED));
		
		httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
				
	}
	
	
	
}


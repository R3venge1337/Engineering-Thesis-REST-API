package engineeringthesis.androidrestapi.controller;



import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import engineeringthesis.androidrestapi.util.JwtResponse;
import engineeringthesis.androidrestapi.util.JwtTokenUtil;
import engineeringthesis.androidrestapi.util.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class LoginController {
	
	
	private final JwtTokenUtil jwtTokenUtil;
	
	private final UserDetailsServiceImpl userDetailsService;
	
	private final AuthenticationManager authenticationManager;
	
	private  String tokenRetrived;
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestParam("username") String username,@RequestParam("password") String password) throws Exception {

		authenticate(username, password);

		final UserDetails userDetails = userDetailsService.loadUserByUsername(username);

		final String token = jwtTokenUtil.generateToken(userDetails);
		
		tokenRetrived = token;

		return ResponseEntity.ok(new JwtResponse(tokenRetrived));
	}
	
	
	@RequestMapping(value = "/token", method = RequestMethod.GET)
	public ResponseEntity<?> getToken() throws Exception {
			
		return ResponseEntity.ok(new JwtResponse(tokenRetrived));
	}
	
	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}

package engineeringthesis.androidrestapi.security.controller;

import engineeringthesis.androidrestapi.security.dto.AuthorizationResponse;
import engineeringthesis.androidrestapi.security.domain.JwtTokenUtil;
import engineeringthesis.androidrestapi.security.domain.UserDetailsService;
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

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
class LoginController {

	private final UserDetailsFacade userDetailsService;

	private final AuthenticationManager authenticationManager;

	private String tokenRetrived;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	ResponseEntity<?> createAuthenticationToken(@RequestParam("username") String username,
			@RequestParam("password") String password) throws Exception {

		authenticate(username, password);

		final UserDetails userDetails = userDetailsService.loadUserByUsername(username);

		final String token = jwtTokenUtil.generateToken(userDetails);

		tokenRetrived = token;

		return ResponseEntity.ok(new AuthorizationResponse(tokenRetrived));
	}

	@RequestMapping(value = "/token", method = RequestMethod.GET)
	ResponseEntity<?> getToken() throws Exception {

		return ResponseEntity.ok(new AuthorizationResponse(tokenRetrived));
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

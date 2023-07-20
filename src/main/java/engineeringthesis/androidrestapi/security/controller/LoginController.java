package engineeringthesis.androidrestapi.security.controller;

import engineeringthesis.androidrestapi.security.AuthenticationFacade;
import engineeringthesis.androidrestapi.security.dto.AuthenticationRequest;
import engineeringthesis.androidrestapi.security.dto.AuthenticationResponse;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
class LoginController {

	private final AuthenticationFacade authenticationFacade;

	@PostMapping("/authenticate")
	AuthenticationResponse authenticate(@RequestBody final AuthenticationRequest request) {
		return authenticationFacade.authenticate(request);
	}

}

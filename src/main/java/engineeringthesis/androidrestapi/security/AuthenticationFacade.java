package engineeringthesis.androidrestapi.security;


import engineeringthesis.androidrestapi.security.dto.AuthenticationRequest;
import engineeringthesis.androidrestapi.security.dto.AuthenticationResponse;

public interface AuthenticationFacade {

  AuthenticationResponse authenticate(final AuthenticationRequest request);
}

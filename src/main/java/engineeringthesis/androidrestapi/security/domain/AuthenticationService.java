package engineeringthesis.androidrestapi.security.domain;

import engineeringthesis.androidrestapi.account.AccountFacade;
import engineeringthesis.androidrestapi.account.dto.AccountDto;
import engineeringthesis.androidrestapi.security.AuthenticationFacade;
import engineeringthesis.androidrestapi.security.dto.AuthenticationRequest;
import engineeringthesis.androidrestapi.security.dto.AuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;


@RequiredArgsConstructor
class AuthenticationService implements AuthenticationFacade {

  private final AccountFacade accountFacade;
  private final JwtUtils jwtUtils;
  private final AuthenticationManager authenticationManager;

  public AuthenticationResponse authenticate(final AuthenticationRequest request) {
    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.login(), request.password()));
    final AccountDto account = accountFacade.findAccountByName(request.login());
    final String jwtToken = jwtUtils.generateToken(account);
    return new AuthenticationResponse(jwtToken, account.name(), account.uuid(),account.role());
  }
}

package engineeringthesis.androidrestapi.security.domain;


import engineeringthesis.androidrestapi.security.dto.LoggedUserData;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

@RequiredArgsConstructor
class JwtAuthenticationFilter extends OncePerRequestFilter {

  private final JwtUtils jwtUtils;

  @Override
  protected void doFilterInternal(
    final @NonNull HttpServletRequest request,
    final @NonNull HttpServletResponse response,
    final @NonNull FilterChain filterChain
  ) throws ServletException, IOException {
    final String authHeader = request.getHeader("Authorization");
    final String jwt;
    final String login;

    if (authHeader == null || !authHeader.startsWith("Bearer ")) {
      filterChain.doFilter(request, response);
      return;
    }

    jwt = authHeader.substring(7);

    login = jwtUtils.extractLogin(jwt);
    if (login != null && SecurityContextHolder.getContext().getAuthentication() == null) {
      final Claims claims = jwtUtils.extractClaims(jwt);
      final String userLogin = claims.get(JwtUtils.USER_LOGIN, String.class);
      final String userType = claims.get(JwtUtils.USER_TYPE, String.class);
      final String customerUuidString = claims.get(JwtUtils.CUSTOMER_UUID, String.class);
      final String userUuidString = claims.get(JwtUtils.USER_UUID, String.class);

      final UUID customerUuid = isNotBlank(customerUuidString) ? UUID.fromString(customerUuidString) : null;
      final UUID userUuid = isNotBlank(userUuidString) ? UUID.fromString(userUuidString) : null;

      if (!jwtUtils.isTokenExpired(jwt)) {
        final UsernamePasswordAuthenticationToken authenticationToken =
          new UsernamePasswordAuthenticationToken(new LoggedUserData(userLogin, userUuid, customerUuid), null, List.of(new SimpleGrantedAuthority(userType)));

        authenticationToken.setDetails(
          new WebAuthenticationDetailsSource().buildDetails(request)
        );

        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
      }
    }

    filterChain.doFilter(request, response);
  }
}

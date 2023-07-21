package engineeringthesis.androidrestapi.security.domain;

import engineeringthesis.androidrestapi.account.dto.AccountDto;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;

import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

@RequiredArgsConstructor
class JwtUtils {

  static final String CUSTOMER_UUID = "customerUuid";
  static final String USER_TYPE = "userType";
  static final String USER_UUID = "userUuid";
  static final String USER_LOGIN = "userLogin";

  private final String secretKey;

  String extractLogin(final String jwt) {
    return extractClaim(jwt, Claims::getSubject);
  }

  <T> T extractClaim(final String token, final Function<Claims, T> claimResolver) {
    final Claims claims = extractClaims(token);
    return claimResolver.apply(claims);
  }

  String generateToken(final AccountDto account) {
    final Map<String, Object> extraClaims = Map.of(
      USER_TYPE, account.role(),
      USER_LOGIN, account.name(),
      USER_UUID, account.uuid());
    return generateToken(extraClaims, account);
  }

  String generateToken(final Map<String, Object> extraClaims, final AccountDto account) {
    return Jwts.builder()
      .setClaims(extraClaims)
      .setSubject(account.name())
      .setIssuedAt(new Date(System.currentTimeMillis()))
      .setExpiration(new Date(System.currentTimeMillis() + TimeUnit.HOURS.toMillis(24)))
      .signWith(getSignInKey(), SignatureAlgorithm.HS512)
      .compact();
  }

  Claims extractClaims(final String token) {
    return Jwts
      .parserBuilder()
      .setSigningKey(getSignInKey())
      .build()
      .parseClaimsJws(token)
      .getBody();
  }

  private Key getSignInKey() {
    final byte[] keyBytes = Decoders.BASE64.decode(secretKey);
    return Keys.hmacShaKeyFor(keyBytes);
  }

  boolean isTokenExpired(final String token) {
    return extractExpiration(token).before(new Date());
  }

  private Date extractExpiration(final String token) {
    return extractClaim(token, Claims::getExpiration);
  }
}

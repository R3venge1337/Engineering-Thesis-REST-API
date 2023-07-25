package engineeringthesis.androidrestapi.common.controller;

import java.util.Set;

import engineeringthesis.androidrestapi.common.exception.DateException;
import engineeringthesis.androidrestapi.common.exception.NotFoundException;
import engineeringthesis.androidrestapi.common.exception.NotUniqueException;
import engineeringthesis.androidrestapi.common.exception.PasswordDoesNotMatchException;
import engineeringthesis.androidrestapi.common.validation.ErrorDto;
import engineeringthesis.androidrestapi.common.validation.ValidationException;
import engineeringthesis.androidrestapi.security.dto.LoggedUserData;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
class ControllerAdvice {

  @ExceptionHandler(Exception.class)
  public ResponseEntity<?> defaultExceptionHandler(final Exception exception) {
    log.error(exception.getMessage(), exception);
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
  }

  @ExceptionHandler(NotFoundException.class)
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  public ErrorDto notFoundException(final NotFoundException exception) {
    log.warn(exception.getMessage(), exception);
    return new ErrorDto(exception.getMessage());
  }

  @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
  @ResponseStatus(value = HttpStatus.METHOD_NOT_ALLOWED)
  public String methodNotAllowed(final HttpRequestMethodNotSupportedException exception) {
    log.warn(exception.getMessage(), exception);
    return exception.getMessage();
  }

  @ExceptionHandler(ValidationException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public Set<ErrorDto> validationException(final ValidationException exception) {
    return exception.getErrorDtos();
  }

  @ExceptionHandler(NotUniqueException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public Set<ErrorDto> notUniqueException(final NotUniqueException exception) {
    log.warn(exception.getMessage(), exception);
    return Set.of(new ErrorDto(exception.getField(), "MUST_BE_UNIQUE"));
  }

  @ExceptionHandler(DateException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ErrorDto dateException(final DateException exception) {
    log.warn(exception.getMessage(), exception);
    return new ErrorDto(exception.getMessage());
  }

  @ExceptionHandler(PasswordDoesNotMatchException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ErrorDto notMatchException(final PasswordDoesNotMatchException exception) {
    log.warn(exception.getMessage(), exception);
    return new ErrorDto("oldPassword", "PASSWORD_DOES_NOT_MATCH");
  }

  @ExceptionHandler(AccessDeniedException.class)
  @ResponseStatus(value = HttpStatus.FORBIDDEN)
  public void accessDeniedException(final AccessDeniedException exception) {
    final LoggedUserData loggedUserData = (LoggedUserData) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    log.info(exception.getMessage() + " for user with login: '%s'".formatted(loggedUserData.userLogin()), exception);
  }

  @ExceptionHandler(AuthenticationException.class)
  @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
  public void authenticationException(final AuthenticationException exception) {
    log.info(exception.getMessage(), exception);
  }

  @ExceptionHandler(ExpiredJwtException.class)
  @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
  public void expiredToken(final ExpiredJwtException exception) {
    log.info(exception.getMessage(), exception);
  }
}
package engineeringthesis.androidrestapi.common.exception;

public class PasswordDoesNotMatchException extends RuntimeException {
  public PasswordDoesNotMatchException(final String message) {
    super(message);
  }
}

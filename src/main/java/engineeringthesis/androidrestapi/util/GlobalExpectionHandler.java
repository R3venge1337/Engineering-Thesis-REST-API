package engineeringthesis.androidrestapi.util;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class GlobalExpectionHandler{

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public CustomErrorResponse noHandlerFoundException(
            NoHandlerFoundException ex) {

        int code = 404;
        String message = "No handler found for your request.";
        return new CustomErrorResponse(LocalDateTime.now(),code, message);
    }
    
    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public CustomErrorResponse noItemFoundException(
           Exception ex) {

        int code = 404;
        String message = "No item find.";
        return new CustomErrorResponse(LocalDateTime.now(),code, message);
    }
    
    @ExceptionHandler(AuthenticationException.class)
    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
    public CustomErrorResponse unAuthorizedException(
           Exception ex) {

        int code = 401;
        String message = "Do not have permission";
        return new CustomErrorResponse(LocalDateTime.now(),code, message);
    }
    
    @ExceptionHandler(HttpServerErrorException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public CustomErrorResponse problemServerException(
           Exception ex) {

        int code = 500;
        String message = "Problem with Server. Please wait for administrator";
        return new CustomErrorResponse(LocalDateTime.now(),code, message);
    }

}
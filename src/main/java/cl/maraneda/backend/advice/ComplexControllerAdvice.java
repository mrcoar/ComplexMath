package cl.maraneda.backend.advice;

import lombok.NonNull;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Objects;

@ControllerAdvice
public class ComplexControllerAdvice extends ResponseEntityExceptionHandler {
    @ExceptionHandler({IllegalArgumentException.class, ArithmeticException.class, NullPointerException.class})
    public ResponseEntity<@NonNull Object> handleBadRequest(RuntimeException ex, WebRequest request) {
        Objects.requireNonNull(ex);
        Objects.requireNonNull(request);
        return super.handleExceptionInternal(ex, ex.getMessage(),
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}

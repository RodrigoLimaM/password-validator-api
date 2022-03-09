package br.com.passwordvalidator.config.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    @Override
    @NonNull
    protected ResponseEntity<Object> handleMissingServletRequestParameter(@NonNull final MissingServletRequestParameterException ex,
                                                                          @NonNull final HttpHeaders headers,
                                                                          @NonNull final HttpStatus status,
                                                                          @NonNull final WebRequest request) {
        Map<Object, Object> errorResponse= Map.of(
                "status", status.value(),
                "details", ex.getMessage()
        );

        return ResponseEntity.badRequest().body(errorResponse);
    }
}

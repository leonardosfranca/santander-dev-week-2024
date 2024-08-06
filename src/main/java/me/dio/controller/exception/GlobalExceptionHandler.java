package me.dio.controller.exception;

import me.dio.domain.model.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Usuario> handley(IllegalArgumentException businessException) {
        return new ResponseEntity(businessException.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
    }
}

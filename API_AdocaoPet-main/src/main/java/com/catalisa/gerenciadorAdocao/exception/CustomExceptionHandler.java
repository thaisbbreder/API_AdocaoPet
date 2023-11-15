package com.catalisa.gerenciadorAdocao.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class CustomExceptionHandler {

    private FieldError error;

    public static class DefaultError{
        public String campo;

        public String mensagem;


    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<List<DefaultError>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        List<DefaultError> defaultError = new ArrayList<>();

        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            var variavel = new DefaultError();
            variavel.campo = error.getField();
            variavel.mensagem = error.getDefaultMessage();
            defaultError.add(variavel);
        }
        return ResponseEntity.badRequest().body(defaultError);
    }
}

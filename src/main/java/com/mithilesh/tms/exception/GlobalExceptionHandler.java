package com.mithilesh.tms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleMethodArgsNotValidException(MethodArgumentNotValidException exception){
        Map<String,String> validationErrors=new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach((errors)->{
            String errorField = ((FieldError) errors).getField();
            String errorMessage = errors.getDefaultMessage();
            validationErrors.put(errorField,errorMessage);
        });
        return new ResponseEntity<Map<String,String>>(validationErrors, HttpStatus.BAD_REQUEST);
    }

}

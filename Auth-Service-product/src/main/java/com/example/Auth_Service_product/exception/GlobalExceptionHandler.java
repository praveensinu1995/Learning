package com.example.Auth_Service_product.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvaildUserException.class)
    public ResponseEntity<Map<String,String>> handelInvaildUserException(InvaildUserException invaildUserException){
        Map<String ,String> errors=new HashMap<>();
                errors.put("error",invaildUserException.getMessage());
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handelMethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException){
        Map<String,String> erorrs=new HashMap<>();

        methodArgumentNotValidException.getBindingResult().getFieldErrors().forEach(
                error->{
                    erorrs.put(error.getField(),error.getDefaultMessage());
                }
        );
        return new ResponseEntity<>(erorrs,HttpStatus.BAD_REQUEST);
    }

}

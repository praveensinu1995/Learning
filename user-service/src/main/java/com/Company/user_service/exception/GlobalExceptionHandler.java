package com.Company.user_service.exception;

import org.springframework.dao.DataIntegrityViolationException;
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
    public ResponseEntity<Map<String, String>> handleValidationErrors(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(
                (error -> {
                    String fieldName = ((FieldError) error).getField();
                    String message = error.getDefaultMessage();
                    errors.put(fieldName, message);
                })
        );
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Map<String, String>> handelDataIntegrityViolationException(DataIntegrityViolationException ex) {
        Map<String ,String> errors=new HashMap<>();
        String message =ex.getRootCause()!=null?ex.getRootCause().getMessage():ex.getMessage();
        if (message.contains("users.UKk8d0f2n7n88w1a16yhua64onx")){
            errors.put("userName","userName alreday present");
        }else if (message.contains("users.UKpwrpg821nujmmnavoq7s420jn")){
            errors.put("emailId","emailId alreday present");
        }else {
            errors.put("error","Data integrity violation: " + message);
        }
        return new ResponseEntity<>(errors,HttpStatus.CONFLICT);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Map<String,String>> handleUserNotFoundException(UserNotFoundException ex){
        Map<String ,String> error=new HashMap<>();
        error.put("error",ex.getMessage());
        return  new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }
}

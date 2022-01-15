package com.omidmohebbise.todoapp.common;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;

import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        if(ex instanceof BindException){
            CustomErrorResponse errors = new CustomErrorResponse();
            errors.setTimestamp(LocalDateTime.now());
            errors.setError(ex.getAllErrors().get(0).getDefaultMessage());
            errors.setStatus(HttpStatus.BAD_REQUEST.value());
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }else{
            return getGlobalExceptionResponse(ex);
        }
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, org.springframework.web.context.request.WebRequest request) {
        if(ex instanceof BindException){
            CustomErrorResponse errors = new CustomErrorResponse();
            errors.setTimestamp(LocalDateTime.now());
            errors.setError(ex.getAllErrors().get(0).getDefaultMessage());
            errors.setStatus(HttpStatus.BAD_REQUEST.value());
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }else{
            return getGlobalExceptionResponse(ex);
        }


    }



    private ResponseEntity<Object> getGlobalExceptionResponse(Exception ex) {
        ex.printStackTrace();
        CustomErrorResponse errors = new CustomErrorResponse();
        errors.setTimestamp(LocalDateTime.now());
        errors.setError("Something is wrong. Call Administrator :)");
        errors.setStatus(HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(errors, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}

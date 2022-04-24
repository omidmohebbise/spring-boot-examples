package com.oms.exception.handler;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class GlobalRestExceptionHandler extends ResponseEntityExceptionHandler {


    @Override
    protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return new ResponseEntity<Object>(
                new ResponseFormat(false,"Missing variable"), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = Throwable.class)
    protected ResponseEntity<Object> handleConflict(

            Exception ex, WebRequest request) {

        HttpStatus httpStatus ;
        String message = ex.getMessage();

        if (ex instanceof ArithmeticException) {
            httpStatus = HttpStatus.BAD_REQUEST;
        } else if (ex instanceof NullPointerException) {
            httpStatus = HttpStatus.BAD_REQUEST;
        }if (ex instanceof WrongUrlException){
            httpStatus = HttpStatus.BAD_GATEWAY;
        }else{
            httpStatus = HttpStatus. BAD_REQUEST;
            message = "Unknown error.";
        }
        return new ResponseEntity<Object>(
                new ResponseFormat(false,message), new HttpHeaders(), httpStatus);
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status,
                                                                         WebRequest request) {
        // do your processing

        // go on (or no) executing the logic defined in the base class
        return super.handleHttpRequestMethodNotSupported(ex, headers, status, request);
    }





}


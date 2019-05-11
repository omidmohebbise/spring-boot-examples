package com.example.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalRestExceptionHandler extends ResponseEntityExceptionHandler {

    //@ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(Exception.class)
    public String defaultExceptionHandler() {
        System.out.println("HOraaaaaaaaaaaaa Error ");
        /*HttpStatus status=HttpStatus.NOT_FOUND;
        ApiErrorResponse response =new ApiErrorResponse.ApiErrorResponseBuilder()
                .withStatus(status)
                .withError_code(status.BAD_REQUEST.name())
                .withMessage("gholomali").build();*/

        return "dasdas";
    }


}


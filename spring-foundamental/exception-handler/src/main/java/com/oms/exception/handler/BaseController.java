package com.oms.exception.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class BaseController {
    //@ExceptionHandler({Exception.class})
    public  Object handleException(){
        return "error 102020: call to administrator";
    }
}

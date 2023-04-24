package com.example.RetoFractalBackend.order.errorHandlers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class OrderNotEditableAdvice {
    @ResponseBody
    @ExceptionHandler (OrderNotEditableException.class)
    @ResponseStatus (HttpStatus.FORBIDDEN)
    String orderNotEditableHandler (OrderNotEditableException exception) {
        return exception.getMessage ();
    }
}

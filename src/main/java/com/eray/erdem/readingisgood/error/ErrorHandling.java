package com.eray.erdem.readingisgood.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class ErrorHandling {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({Exception.class})
    protected ResponseEntity<Object> handleMethodArgumentNotValid(Exception e, WebRequest request) {
        CommonException myException = new CommonException(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), e.getMessage());
        return new ResponseEntity(myException, HttpStatus.BAD_REQUEST);
    }


}
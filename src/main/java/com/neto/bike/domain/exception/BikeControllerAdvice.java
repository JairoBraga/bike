package com.neto.bike.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

@ControllerAdvice
public class BikeControllerAdvice {

    @ResponseBody
    @ExceptionHandler(BikeNotFound.class)
    public ResponseEntity<MessageExceptionHandler> bikeNotFoundException(){
        MessageExceptionHandler errorMessage = new MessageExceptionHandler(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(),"Recurso não encontrado");
        return new ResponseEntity<>(errorMessage,HttpStatus.NOT_FOUND);
    }
}

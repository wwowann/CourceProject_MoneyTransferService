package cource_project_money_transfer_service.demo.controller;

import cource_project_money_transfer_service.demo.handlerexceptions.InvalidRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@ResponseStatus (HttpStatus.BAD_REQUEST)
public class ExceptionHandlerAdvice {
    @ExceptionHandler(Exception.class)//500 error
    public ResponseEntity<String> errorConfirmation(InvalidRequest e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }

    @ExceptionHandler(Exception.class)//400 error
    public ResponseEntity<String> errorInputData(InvalidRequest e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}

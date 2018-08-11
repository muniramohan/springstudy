package com.bnp.showroom.config;


import com.bnp.showroom.exceptionhandling.ExceptionResponse;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.sql.SQLException;


/**
 * Created by cs8593 on 19.07.2018.
 */
@ControllerAdvice
public class ControllerConfiguration {
    ExceptionResponse response = new ExceptionResponse();
    private final HttpStatus Status = HttpStatus.BAD_REQUEST;

    @ExceptionHandler(TransactionSystemException.class)
    public  ResponseEntity<ExceptionResponse>  notValid(TransactionSystemException ex) {
        response.setErrorCode("not found");
        response.setErrorMessage(ex.getMessage());
        return new ResponseEntity<>(response, Status);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity handleConstraintViolationException(SQLException ex){
        response.setErrorCode("not found");
        response.setErrorMessage(ex.getMessage());
        return new ResponseEntity<>(response, Status);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleAllException(Exception ex, WebRequest request){
        response.setErrorCode("not found");
        response.setErrorMessage(ex.getMessage() + "Details : " + request.getDescription(false));
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
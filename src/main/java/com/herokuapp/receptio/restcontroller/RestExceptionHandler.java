package com.herokuapp.receptio.restcontroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);

    // TODO: Actually handle different exceptions.
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(Exception e) {
        ErrorResponse response = new ErrorResponse();

        response.setMessage(e.getLocalizedMessage());
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setTimestamp(System.currentTimeMillis());

        logger.error(e.getLocalizedMessage(), e);

        return new ResponseEntity<ErrorResponse>(response, HttpStatus.BAD_REQUEST);
    }
}
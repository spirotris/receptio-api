package com.herokuapp.receptio.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);

    @ExceptionHandler(InvalidAuthorizationException.class)
    public ResponseEntity<ErrorResponse> handleInvalidAuthorizationException(InvalidAuthorizationException e) {
        ErrorResponse response = new ErrorResponse();

        response.setMessage("Access denied");
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setTimestamp(System.currentTimeMillis());

        logger.error("InvalidAuthorizationException: " + e.getMessage(), e);

        return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);

    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException e) {
        ErrorResponse response = new ErrorResponse();

        response.setMessage("Resource not found");
        response.setStatus(HttpStatus.NO_CONTENT.value());
        response.setTimestamp(System.currentTimeMillis());

        logger.info("ResourceNotFoundException: " + e.getMessage(), e);

        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(BadResourceException.class)
    public ResponseEntity<ErrorResponse> handleBadResourceException(BadResourceException e) {
        ErrorResponse response = new ErrorResponse();

        response.setMessage("Resource not found");
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setTimestamp(System.currentTimeMillis());

        logger.info("ResourceNotFoundException: " + e.getMessage(), e);

        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(Exception e) {
        ErrorResponse response = new ErrorResponse();

        response.setMessage("Oh noes! An unexpected error has occured.");
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.setTimestamp(System.currentTimeMillis());

        logger.error("Exception: " + e.getMessage(), e);

        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
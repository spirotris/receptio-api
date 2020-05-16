package com.herokuapp.receptio.exception;

import lombok.Data;

@Data
public class BadResourceException extends RuntimeException {

    public BadResourceException(String message) {
        super(message);
    }

}

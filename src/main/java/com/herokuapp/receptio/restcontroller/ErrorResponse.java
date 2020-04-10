package com.herokuapp.receptio.restcontroller;

import lombok.Data;

@Data
public class ErrorResponse {

    private int status;
    private String message;
    private long timestamp;

}

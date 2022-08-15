package com.neto.bike.domain.exception;

import java.time.LocalDateTime;

public class MessageExceptionHandler {

    private LocalDateTime timestamp;
    private Integer status;
    private String message;

    public MessageExceptionHandler() {
    }

    public MessageExceptionHandler(LocalDateTime timestamp, Integer status, String message) {
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
    }


}

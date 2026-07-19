package com.example.ArpegioBackend.exception;

import java.time.LocalDateTime;

public class ResourceNotFoundException extends RuntimeException {

    String field;
    String value;
    LocalDateTime timestamp;

    public ResourceNotFoundException(String message) {

        super(message);
    }

    public ResourceNotFoundException(String message, String field, String value, LocalDateTime timestamp) {
        super(message);
        this.field = field;
        this.value = value;
        this.timestamp = timestamp;
    }
}

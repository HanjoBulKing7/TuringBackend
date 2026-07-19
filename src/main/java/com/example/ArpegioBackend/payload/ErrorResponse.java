package com.example.ArpegioBackend.payload;

import java.time.LocalDateTime;

public record ErrorResponse(

        String message,
        int status,
        LocalDateTime timestamp
) {


}

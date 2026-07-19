package com.example.ArpegioBackend.payload;

import java.time.LocalDateTime;

public record ApiResponse<J>(
        String message,
        J data,
        LocalDateTime timestamp
) { }
package com.example.ArpegioBackend.payload;

public record AuthRequest(
        String username,
        String password
) {
}

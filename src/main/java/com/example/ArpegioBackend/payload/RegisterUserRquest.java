package com.example.ArpegioBackend.payload;

import com.example.ArpegioBackend.entity.Role;
import jakarta.validation.constraints.NotBlank;

public record RegisterUserRquest(
        @NotBlank
        String username,
        @NotBlank
        String password,
        @NotBlank
        String email,
        Role role
) { }
package com.example.ArpegioBackend.service;

import com.example.ArpegioBackend.payload.ApiResponse;
import com.example.ArpegioBackend.payload.AuthRequest;

public interface AuthService {

    String authenticateUser(AuthRequest authRequest);
}

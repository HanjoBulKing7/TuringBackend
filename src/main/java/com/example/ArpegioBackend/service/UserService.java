package com.example.ArpegioBackend.service;

import com.example.ArpegioBackend.entity.Users;
import com.example.ArpegioBackend.payload.ApiResponse;
import com.example.ArpegioBackend.payload.RegisterUserRquest;
import com.example.ArpegioBackend.payload.UserDTO;

public interface UserService {

    UserDTO registerUser(RegisterUserRquest registerUserRquest);
}

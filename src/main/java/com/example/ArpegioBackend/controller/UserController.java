package com.example.ArpegioBackend.controller;


import com.example.ArpegioBackend.payload.ApiResponse;
import com.example.ArpegioBackend.payload.AuthRequest;
import com.example.ArpegioBackend.payload.RegisterUserRquest;
import com.example.ArpegioBackend.payload.UserDTO;
import com.example.ArpegioBackend.service.AuthService;
import com.example.ArpegioBackend.service.UserService;
import com.example.ArpegioBackend.utils.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<String>> generateToken(@RequestBody AuthRequest authRequest){

        String generatedToken = authService.authenticateUser(authRequest);

        return ResponseEntity.status(HttpStatus.OK)
                .body( new ApiResponse<>(
                        "Logged in successfully!",
                        generatedToken,
                        LocalDateTime.now()
                        )
                );
    }

    @PostMapping("/signup")
    public ResponseEntity<ApiResponse<UserDTO>> registerUser(@RequestBody RegisterUserRquest registerUserRquest){

        UserDTO registeredUser = userService.registerUser(registerUserRquest);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>(
                        "User registered successfully",
                        registeredUser,
                        LocalDateTime.now()
                ));
    }

}

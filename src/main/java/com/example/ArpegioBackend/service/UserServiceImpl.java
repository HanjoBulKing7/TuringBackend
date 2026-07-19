package com.example.ArpegioBackend.service;

import com.example.ArpegioBackend.entity.Role;
import com.example.ArpegioBackend.entity.Users;
import com.example.ArpegioBackend.mapper.UserMapper;
import com.example.ArpegioBackend.payload.ApiResponse;
import com.example.ArpegioBackend.payload.RegisterUserRquest;
import com.example.ArpegioBackend.payload.UserDTO;
import com.example.ArpegioBackend.repository.UserDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDetailsRepository userDetailsRepository;
    private final PasswordEncoder  passwordEncoder;
    private final UserMapper userMapper;

    @Override
    public UserDTO registerUser(RegisterUserRquest registerUserRequest) {
        /// Check that the user does not exist already ( Username & Email address )
        if(userDetailsRepository.findByUsername(registerUserRequest.username()).isPresent()){
            if( userDetailsRepository.findByUserNameAndEmail(registerUserRequest.username(), registerUserRequest.email()).isPresent() ){
                throw new RuntimeException("User already exists");
            }
        }

        Users user  = new Users();
        user.setUsername(registerUserRequest.username());
        user.setEmail(registerUserRequest.email());
        user.setPassword(passwordEncoder.encode(registerUserRequest.password())); /// Use the existing bean to encode the password
        user.setRole(Role.USER);

        Users savedUser = userDetailsRepository.save(user);
        return userMapper.mapToDto(savedUser);
    }
}

package com.example.ArpegioBackend.config;

import com.example.ArpegioBackend.entity.Role;
import com.example.ArpegioBackend.entity.Users;
import com.example.ArpegioBackend.repository.UserDetailsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Configuration
public class AdminInitializer {

    @Bean
    public CommandLineRunner createAdminUser(UserDetailsRepository userDetailsRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if(userDetailsRepository.findByUsername("admin").isEmpty()){
                Users admin = new Users();
                admin.setUsername("admin");
                admin.setPassword(passwordEncoder.encode("admin1234"));
                admin.setRole(Role.ADMIN);

                userDetailsRepository.save(admin);
                System.out.println("Admin has been created");
            }

            if(userDetailsRepository.findByUsername("user").isEmpty()){
                Users admin = new Users();
                admin.setUsername("user");
                admin.setPassword(passwordEncoder.encode("user1234"));
                admin.setRole(Role.USER);

                userDetailsRepository.save(admin);
                System.out.println("User has been created");
            }
        };
    }
}

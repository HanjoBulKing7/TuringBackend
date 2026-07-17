package com.example.ArpegioBackend.config;

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
                admin.setRole("ADMIN");

                userDetailsRepository.save(admin);
                System.out.println("Admin has been created");
            }
        };
    }
}

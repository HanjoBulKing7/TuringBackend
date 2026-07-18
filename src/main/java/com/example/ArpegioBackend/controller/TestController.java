package com.example.ArpegioBackend.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/health")
    public String health() {
        return "OK";
    }

    @DeleteMapping("/health")
    @PreAuthorize("hasAuthority('UPDATE')")
    public String deleteHealth() {
        return "Deleted";
    }
}

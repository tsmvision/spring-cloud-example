package com.example.userservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class UsersController {

    @Value("${greeting.message}")
    private String greetingMessage;

    @GetMapping("/health-check")
    public ResponseEntity<String> status() {
        return new ResponseEntity<>("It's working in the User Service", HttpStatus.OK);
    }

    @GetMapping("/welcome")
    public ResponseEntity<String> welcome() {
        return new ResponseEntity<>(greetingMessage, HttpStatus.OK);
    }
}

package com.example.firstservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/first-service")
public class HelloController {

    @GetMapping("/welcome")
    public ResponseEntity<String> getHello() {
        return new ResponseEntity<>("Hello from first-service", HttpStatus.OK);
    }
}

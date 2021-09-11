package com.example.secondservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/second-service")
public class HelloController {

    @GetMapping("/welcome")
    public ResponseEntity<String> getHello() {
        return new ResponseEntity<>("Hello From Second-service", HttpStatus.OK);
    }
}

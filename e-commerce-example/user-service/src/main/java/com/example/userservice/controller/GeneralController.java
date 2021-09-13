package com.example.userservice.controller;

import com.example.userservice.vo.Greeting;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user-service")
@RequiredArgsConstructor
public class GeneralController {

    private final Greeting greeting;
    private final Environment environment;

    @GetMapping("/health_check")
    public ResponseEntity<String> status() {
        return new ResponseEntity<>(
                String.format(
                        "It's working in the User Service on Port: %s",
                        environment.getProperty("local.server.port")
                ),
                HttpStatus.OK
        );
    }

    @GetMapping("/welcome")
    public ResponseEntity<String> welcome() {
        return new ResponseEntity<>(greeting.getMessage(), HttpStatus.OK);
    }
}

package com.example.firstservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/first-service")
@Slf4j
public class HelloController {

    @Value("${server.port}")
    private String portValue;

    @GetMapping("/welcome")
    public ResponseEntity<String> getHello() {
        return new ResponseEntity<>("Hello from first-service", HttpStatus.OK);
    }

    @GetMapping("/message")
    public ResponseEntity<String> getMessage(@RequestHeader("first-request") String header) {
        log.info(header);
        return new ResponseEntity<>("Hello World in First Service", HttpStatus.OK);
    }

    @GetMapping("/check")
    public ResponseEntity<String> getCheck(HttpServletRequest request) {

        log.info("Server port={}", request.getServerPort());
        return new ResponseEntity<>(String.format("First Service on PoRT %s", portValue), HttpStatus.OK);
    }
}

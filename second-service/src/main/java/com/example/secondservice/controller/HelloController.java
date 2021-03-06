package com.example.secondservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/second-service")
@Slf4j
public class HelloController {

    @GetMapping("/welcome")
    public ResponseEntity<String> getHello() {
        return new ResponseEntity<>("Hello From Second-service", HttpStatus.OK);
    }

    @GetMapping("/message")
    public ResponseEntity<String> getMessage(@RequestHeader("second-request") String header) {
        log.info(header);
        return new ResponseEntity<>("Hello World in Second Service", HttpStatus.OK);
    }

    @GetMapping("/check")
    public ResponseEntity<String> getCheck() {
        return new ResponseEntity<>("This is from second-service!!!", HttpStatus.OK);
    }
}

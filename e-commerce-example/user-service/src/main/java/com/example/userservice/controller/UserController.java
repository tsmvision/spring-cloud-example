package com.example.userservice.controller;

import com.example.userservice.domain.dto.UserDto;
import com.example.userservice.service.UserService;
import com.example.userservice.vo.RequestUser;
import com.example.userservice.vo.ResponseUser;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user-service/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<ResponseUser>> getUsers() {
        List<ResponseUser> responseUsers = new ArrayList<>();
        List<UserDto> userDtos = userService.findAllUsers();

        if (userDtos != null) {
            userDtos.forEach(userDto -> {
                responseUsers.add(modelMapper.map(userDtos, ResponseUser.class));
            });
        }

        return new ResponseEntity<>(responseUsers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseUser> getUser(@PathVariable Long id) throws NotFoundException {
        Optional<UserDto> userDto = userService.findById(id);

        if (userDto.isEmpty()) {
            throw new NotFoundException(String.format("User not found"));
        }

        return new ResponseEntity<>(
                modelMapper.map(userDto.get(), ResponseUser.class), HttpStatus.OK
        );
     }

//     @GetMapping("/{userId}")
//     public ResponseEntity<ResponseUser> getUserByUserId(@PathVariable String userId) {
//        Optional<UserDto> userDto = userService.findByUserId(userId);
//        return new ResponseEntity<>(
//                modelMapper.map(userDto, ResponseUser.class), HttpStatus.OK
//        );
//     }

    @PostMapping
    public ResponseEntity<ResponseUser> createUser(@RequestBody RequestUser user) {
        Optional<UserDto> userDto = userService.createUser(
                modelMapper.map(user, UserDto.class)
        );

        return userDto.map(
                dto -> new ResponseEntity<>(modelMapper.map(dto, ResponseUser.class), HttpStatus.CREATED)
        ).orElseGet(() -> new ResponseEntity<>(new ResponseUser(), HttpStatus.CREATED));

    }
}

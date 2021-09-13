package com.example.userservice.service;

import com.example.userservice.domain.dto.UserDto;
import javassist.NotFoundException;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<UserDto>  createUser(UserDto userDto);
    List<UserDto> findAllUsers();
    Optional<UserDto> findById(Long id) throws NotFoundException;
    Optional<UserDto> findByUserId(String userId);
}

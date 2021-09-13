package com.example.userservice.service;

import com.example.userservice.domain.User;
import com.example.userservice.domain.dto.UserDto;
import com.example.userservice.domain.repository.UserRepository;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.hibernate.cfg.Environment;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public Optional<UserDto> createUser(UserDto userDto) {

        userDto.setUserId(UUID.randomUUID().toString());
        User user = modelMapper.map(userDto, User.class);
        user.setEncryptedPassword(passwordEncoder.encode(userDto.getPassword()));
        userRepository.save(user);
        return Optional.of(userDto);
    }

    @Override
    public List<UserDto> findAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = new ArrayList<>();
        if (users != null) {
            users.forEach(user -> {
                userDtos.add(modelMapper.map(user, UserDto.class));
            });
        }

        return userDtos;
    }

    @Override
    public Optional<UserDto> findById(Long id) {
        Optional<User> user = userRepository.findById(id);

        if (user.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(modelMapper.map(user, UserDto.class));
    }

    @Override
    public Optional<UserDto> findByUserId(String userId) {
        Optional<User> user = userRepository.findByUserId(userId);

        if (user.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(modelMapper.map(user, UserDto.class));
    }
}

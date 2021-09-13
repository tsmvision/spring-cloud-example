package com.example.userservice.domain.repository;

import com.example.userservice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findAll();
    Optional<User> findByUserId(String userId);
}

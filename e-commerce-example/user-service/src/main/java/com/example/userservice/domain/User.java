package com.example.userservice.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "email", nullable = false, length = 50, unique = true)
    private String email;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "user_id", nullable = false, unique = true)
    private String userId;

    @Column(name = "encryptedPassword", nullable = false, unique = true)
    private String encryptedPassword;

}

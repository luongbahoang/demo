package com.example.demo.service;

import com.example.demo.model.User;

import java.util.Optional;

public interface IUserService {
    void deleteById(Long id);
    Optional<User> findByCode(String code);
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByPersonalemail(String personalemail);
    Boolean existsByCode(String code);
    User save(User user);
}

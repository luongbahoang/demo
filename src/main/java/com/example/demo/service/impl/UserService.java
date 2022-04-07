package com.example.demo.service.impl;

import com.example.demo.Repository.IUsersRepository;
import com.example.demo.model.User;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserService implements IUserService {
    @Autowired
    IUsersRepository usersRepository;


    @Override
    public void deleteById(Long id) {
        usersRepository.deleteById(id);
    }

    @Override
    public Optional<User> findByCode(String code) {
        return usersRepository.findByCode(code);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return usersRepository.findByUsername(username);
    }

    @Override
    public Boolean existsByUsername(String username) {
        return usersRepository.existsByUsername(username);
    }

    @Override
    public Boolean existsByPersonalemail(String personalemail) {
        return usersRepository.existsByPersonalemail(personalemail);
    }

    @Override
    public Boolean existsByCode(String code) {
        return usersRepository.existsByCode(code);
    }

    @Override
    public User save(User user) {
        return usersRepository.save(user);
    }
}

package com.codegym.jwt_springboot_angular.service.impl;

import com.codegym.jwt_springboot_angular.model.User;
import com.codegym.jwt_springboot_angular.repository.IUserRepository;
import com.codegym.jwt_springboot_angular.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserService implements IUserService {
    @Autowired
    IUserRepository userRepository;

    @Override
    public Optional<User> findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public Boolean existsUserByUserName(String name) {
        return userRepository.existsUserByUserName(name);
    }

    @Override
    public Boolean existsUserByEmail(String email) {
        return userRepository.existsUserByEmail(email);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}

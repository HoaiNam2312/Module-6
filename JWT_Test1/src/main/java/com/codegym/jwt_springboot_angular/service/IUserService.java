package com.codegym.jwt_springboot_angular.service;

import com.codegym.jwt_springboot_angular.model.User;

import java.util.Optional;

public interface IUserService {
    Optional<User> findByUserName(String name); // Tìm khiếm User có trong DB không ?

    Boolean existsUserByUserName(String name);
    Boolean existsUserByEmail(String email);

    void save(User user);
}

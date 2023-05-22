package com.codegym.jwt_springboot_angular.repository;

import com.codegym.jwt_springboot_angular.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserName(String userName); // Tìm khiếm User có trong DB không ?
    Boolean existsUserByUserName(String name);
    Boolean existsUserByEmail(String email);

}

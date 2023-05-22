package com.codegym.jwt_springboot_angular.repository;

import com.codegym.jwt_springboot_angular.model.Role;
import com.codegym.jwt_springboot_angular.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByName(RoleName name);
}

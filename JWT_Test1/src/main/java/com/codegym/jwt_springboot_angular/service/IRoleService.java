package com.codegym.jwt_springboot_angular.service;

import com.codegym.jwt_springboot_angular.model.Role;
import com.codegym.jwt_springboot_angular.model.RoleName;

import java.util.Optional;

public interface IRoleService {
    Optional<Role> findByName(RoleName name);
}

package com.codegym.jwt_springboot_angular.service.impl;

import com.codegym.jwt_springboot_angular.model.Role;
import com.codegym.jwt_springboot_angular.model.RoleName;
import com.codegym.jwt_springboot_angular.repository.IRoleRepository;
import com.codegym.jwt_springboot_angular.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class RoleService implements IRoleService {
    @Autowired
    IRoleRepository roleRepository;
    @Override
    public Optional<Role> findByName(RoleName name) {
        return roleRepository.findByName(name);
    }
}

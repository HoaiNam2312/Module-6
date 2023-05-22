package com.codegym.jwt_springboot_angular.security.userPrincal;

import com.codegym.jwt_springboot_angular.model.User;
import com.codegym.jwt_springboot_angular.repository.IUserRepository;
import com.codegym.jwt_springboot_angular.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service //Service này tìm xem User có tồn tại trong DB không
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    IUserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username).orElseThrow(() -> new UsernameNotFoundException("Not found account with username: " + username));
        return UserPrinciple.build(user);
    }
}

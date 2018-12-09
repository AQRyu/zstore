package com.aqryuz.zstore.service;

import org.springframework.stereotype.Service;

import com.aqryuz.zstore.entity.User;
import com.aqryuz.zstore.repository.UserRepository;
@Service
public class UserService {

    private UserRepository userRepository;

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email).get();
    }
}
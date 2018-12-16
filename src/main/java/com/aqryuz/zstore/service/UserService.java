package com.aqryuz.zstore.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aqryuz.zstore.entity.User;
import com.aqryuz.zstore.repository.UserRepository;
@Service
@Transactional
public class UserService {
	@Autowired
    private UserRepository userRepository;
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email).get();
    }
	public List<User> findAll() {
		return userRepository.findAll();
	}
	public User findUserById(long id) {
		return userRepository.findById(id).get();
	}
}
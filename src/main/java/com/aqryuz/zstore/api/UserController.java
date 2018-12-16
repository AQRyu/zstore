package com.aqryuz.zstore.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.aqryuz.zstore.entity.User;
import com.aqryuz.zstore.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	@GetMapping(value = "/api/users")
	public List<User> users(Model model){
		return userService.findAll();
	}
	
	@GetMapping(value = "/api/users/{id}")
	public User getUserById(@PathVariable("id") long id){
		return userService.findUserById(id);
	}
}

package com.aqryuz.zstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aqryuz.zstore.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private UserService userService;
	@GetMapping(value = {"","/", "index", "home"})
	public String admin() {
		return "admin/home";
	}
	
	@GetMapping(value = {"/users"})
	public String users() {
		return "admin/users";
	}
	
	@GetMapping(value = {"/orders"})
	public String orders() {
		return "admin/orders";
	}

}

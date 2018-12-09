package com.aqryuz.zstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MerchantController {
	@GetMapping("/merchant")
	public String home(Model model) {
		model.addAttribute("message", "welcome to merchant page");
		return "merchant/index";
	}
}

package com.aqryuz.zstore.controller;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aqryuz.zstore.entity.Role;
import com.aqryuz.zstore.entity.User;
import com.aqryuz.zstore.repository.RoleRepository;
import com.aqryuz.zstore.repository.UserRepository;
import com.aqryuz.zstore.service.EmailService;
import com.braintreegateway.BraintreeGateway;
import com.braintreegateway.TransactionRequest;



@Controller
public class RegisterController {
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private EmailService emailService;
	@Autowired
	private BraintreeGateway gateway;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@GetMapping("/register")
	public String getRegisterPage(@RequestParam(value = "role", required = true) String role, Model model) {
		User user = new User();
		Role r = roleRepository.findRoleByName(role);
		user.setRole(r);
		model.addAttribute("user", user);
		return "register";
	}

	@PostMapping("/register")
	public String doRegister(User user, Model model){
		user.setExpiredDate(LocalDateTime.now().plusMonths(user.getMonth()));
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		if(user.getRole().getName().equals("CUSTOMER")) {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			registerSuccessfully(user, model);
			return "registerSuccess";
		}
		userRepository.save(user);
		//Calculate the amount for merchant to pay 
		BigDecimal base = new BigDecimal(0);
		BigDecimal amount = new BigDecimal(0);
		if(user.getType().equals("Individual")) {
			base = new BigDecimal(2);
			amount = new BigDecimal(2);
			amount = amount.multiply(new BigDecimal(user.getMonth()));
		}else {
			base = new BigDecimal(20);
			amount = new BigDecimal(5);
			amount = amount.multiply(new BigDecimal(user.getMonth()));
		}
		String clientToken = gateway.clientToken().generate();
		model.addAttribute("clientToken", clientToken);
		model.addAttribute("amount", base.add(amount));
		model.addAttribute("id", user.getId());
		return "registerPayment";
	}


	@PostMapping(value = "/registerPayment")
	public String doRegisterPayment(@RequestParam("payment_method_nonce") String nonce,
			@RequestParam("amount") String amount,
			@RequestParam("id") Long id,
			Model model,
			RedirectAttributes redirectAttributes){
		BigDecimal decimalAmount;
	       try {
	           decimalAmount = new BigDecimal(amount);
	       } catch (NumberFormatException e) {
	           redirectAttributes.addFlashAttribute("errorDetails", "Error: 81503: Amount is an invalid format.");
	           return "redirect:checkouts";
	       }
		//submit the request for processing
		TransactionRequest request = new TransactionRequest()
				.amount(decimalAmount)
				.paymentMethodNonce(nonce)
				.options()
				.submitForSettlement(true)
				.done();

		//get the response
		User user = userRepository.findById(id).get();
		registerSuccessfully(user, model);
		return "registerSuccess";

	}

	public void registerSuccessfully(User user, Model model){
		//Save before send email to make sure account is created
		System.out.println("Password" +user.getPassword());
		userRepository.save(user);

		String url = "127.0.0.1:8080/enabled/"+user.getId();
		//prepare email
		String to = user.getEmail();
		String subject = "Register confirmation";
		String text = "Click " + url + " to active your account";
		//send email
		emailService.sendSimpleMessage(to, subject, text);
		model.addAttribute("message", "Register successfully, please check your email to confirm registration.");

	}

	@GetMapping("/enabled/{id}")
	public String enable(@PathVariable("id") Long id, Model model) {
		User user = userRepository.findById(id).get();
		user.setEnabled(true);
		userRepository.save(user);
		model.addAttribute("message", "Register successfully, try sign in.");
		return "registerSuccess";
	}
}

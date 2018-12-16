package com.aqryuz.zstore.utils;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.aqryuz.zstore.entity.User;
import com.aqryuz.zstore.repository.UserRepository;

public class SpringSecurityAuditorAware implements AuditorAware<User> {
	@Autowired
	private UserRepository userRepository;
	public Optional<User> getCurrentAuditor() {
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null || !authentication.isAuthenticated()) {
            return userRepository.findByEmail("merchant1@gmail.com");
        }
		User user =  (User) authentication.getPrincipal();
		System.out.println("Call from SpringSecurityAuditorAware " + user);
		return Optional.of(user);
	}
}
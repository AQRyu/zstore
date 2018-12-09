package com.aqryuz.zstore.utils;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.aqryuz.zstore.entity.User;
import com.aqryuz.zstore.repository.UserRepository;

public class SpringSecurityAuditorAware implements AuditorAware<User> {
	@Autowired
	private UserRepository userRepository;
	
	  public Optional<User> getCurrentAuditor() {

	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    
	    if (auth instanceof AnonymousAuthenticationToken) {
	    	return null;
	    }
	    String currentUserName = auth.getName();
	    return userRepository.findByEmail(currentUserName);
	  }
	}
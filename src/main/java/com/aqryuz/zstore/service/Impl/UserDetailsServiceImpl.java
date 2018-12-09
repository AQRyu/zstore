package com.aqryuz.zstore.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.aqryuz.zstore.entity.User;
import com.aqryuz.zstore.repository.UserRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(email).get();
		System.out.println("User = " + user);
		
		if(user == null) {
			throw new UsernameNotFoundException("User " + email + "was not found");
		}
		
		String role = user.getRole().getName();
		
		List<GrantedAuthority> grantList = new ArrayList<>();
		GrantedAuthority authority = new SimpleGrantedAuthority(role);
		grantList.add(authority);
		
		UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), grantList);
		return userDetails;
	}

}

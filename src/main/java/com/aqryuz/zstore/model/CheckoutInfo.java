package com.aqryuz.zstore.model;

import com.aqryuz.zstore.entity.User;

import lombok.Data;

@Data
public class CheckoutInfo {
	private String name;
	private String email;
	private String address;
	private String city;
	private String phone;
	private boolean saved;
	
	public CheckoutInfo(User user){
		this.email = user.getEmail();
		this.name = user.getName();
		this.address = user.getAddress();
		this.city = user.getCity();
		this.phone = user.getPhone();
		this.saved = false;
	}
}

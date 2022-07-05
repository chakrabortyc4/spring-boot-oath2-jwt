package com.practice.springbootoath2jwt.helper;

import org.springframework.security.core.userdetails.User;

import com.practice.springbootoath2jwt.model.UserPojo;

public class UserHelper extends User{
	

	/**
	 * 
	 */	
	private static final long serialVersionUID = -2775419886319133007L;

	public UserHelper(UserPojo userPojo) {
		super(userPojo.getUserName(), userPojo.getPassword(), userPojo.getListOfGeantedAuthority());
		// TODO Auto-generated constructor stub
	}

}

package com.practice.springbootoath2jwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.practice.springbootoath2jwt.DAO.UsersDAO;
import com.practice.springbootoath2jwt.helper.UserHelper;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	UsersDAO usersDAO;
	
	
	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		try {
				return new UserHelper(usersDAO.getUserDetails(username));
		    }catch(Exception e) {
		    	throw new UsernameNotFoundException(username+" is Invalid USER");
		       }
	}

}

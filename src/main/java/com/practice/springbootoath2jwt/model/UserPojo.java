package com.practice.springbootoath2jwt.model;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class UserPojo {
	
	private String userName;
	private String password;
	private Collection<GrantedAuthority> listOfGeantedAuthority = new ArrayList<>();

}

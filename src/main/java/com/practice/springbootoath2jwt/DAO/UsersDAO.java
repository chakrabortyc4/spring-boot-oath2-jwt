package com.practice.springbootoath2jwt.DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Repository;

import com.practice.springbootoath2jwt.model.UserPojo;

@Repository
public class UsersDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public UserPojo getUserDetails(String username) {
		
		Collection<GrantedAuthority> listOfGrantedAuthority = new ArrayList<>();
		String userSql ="select * from users where username=?";
		List<UserPojo> userList = jdbcTemplate.query(userSql, new String[] {username},
				           ( ResultSet rs , int row ) -> {
				        	   
				        	   UserPojo userPojo = new UserPojo(); 
				        	   userPojo.setUserName(username);
				        	   userPojo.setPassword(rs.getString("PASSWORD"));
				        	   return userPojo;
				        	   
				           });
		if(userList.size()>0) {
			GrantedAuthority grantedAuthority =new SimpleGrantedAuthority("ROLE_SYSTEMADMIN");
			listOfGrantedAuthority.add(grantedAuthority);
			userList.get(0).setListOfGeantedAuthority(listOfGrantedAuthority);
			return userList.get(0);
		  }
		else return null;
	}

}

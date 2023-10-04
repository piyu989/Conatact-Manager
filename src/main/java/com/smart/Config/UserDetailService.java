package com.smart.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.smart.dao.userRepo;
import com.smart.entites.User;

public class UserDetailService implements UserDetailsService {
	@Autowired
	private userRepo repo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User u=repo.getUserByUserName(username);
		if(u==null) {
			throw new UsernameNotFoundException("not found");
		}
		CustomerUserDetails details=new CustomerUserDetails(u);
		return details;
	}

}

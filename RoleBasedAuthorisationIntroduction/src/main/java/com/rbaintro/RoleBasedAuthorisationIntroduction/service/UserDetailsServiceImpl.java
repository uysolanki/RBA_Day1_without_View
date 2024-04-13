package com.rbaintro.RoleBasedAuthorisationIntroduction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rbaintro.RoleBasedAuthorisationIntroduction.entity.User;
import com.rbaintro.RoleBasedAuthorisationIntroduction.repository.UserRepository;
import com.rbaintro.RoleBasedAuthorisationIntroduction.security.MyUserDetails;

@Service
public class UserDetailsServiceImpl implements UserDetailsService 
{

	@Autowired
	UserRepository userrepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user=userrepo.getUserByUsername(username);
		if(user==null)
		{
			throw new UsernameNotFoundException("Could Not Find User");
		}
		return new MyUserDetails(user);
	}

}

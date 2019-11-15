package com.talan.recrutement.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.talan.recrutement.persistence.entity.UserEntity;
import com.talan.recrutement.persistence.repository.UserRepository;

@Service
public class UserPrincipalDetailsService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		/*
		 * rule not respected because we need to throw exception if the user does not exist
		 */

		UserEntity user = userRepository.findById(username).get();


		return new UserPrincipal(user);
	}

	

}

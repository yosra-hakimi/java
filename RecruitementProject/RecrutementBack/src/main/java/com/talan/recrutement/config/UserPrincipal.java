package com.talan.recrutement.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.talan.recrutement.persistence.entity.UserEntity;

public class UserPrincipal implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private UserEntity userEntity;

	public UserPrincipal(UserEntity user) {
		this.userEntity = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		List<GrantedAuthority> authorities = new ArrayList<>();
		
		authorities.add(new SimpleGrantedAuthority("ROLE_"+this.userEntity.getProfile().getProfileName()));
		System.out.println("ROLE_"+this.userEntity.getProfile().getProfileName());

		return authorities;

	}

	@Override
	public String getPassword() {
		return this.userEntity.getPassword();
	}

	@Override
	public String getUsername() {

		return this.userEntity.getMail();
	}

	public String getUserFirstName() {
		return this.userEntity.getFirstName();
	}

	public String getUserLastName() {
		return this.userEntity.getLastName();
	}

	public String getUserProfile() {
		return this.userEntity.getProfile().getProfileName();
	}

	@Override
	public boolean isAccountNonExpired() {

		return true;
	}

	@Override
	public boolean isAccountNonLocked() {

		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {

		return true;
	}

	@Override
	public boolean isEnabled() {

		return true;
	}

}

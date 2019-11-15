package com.thp.spring.simplecontext.service;

import java.util.HashMap;

import com.thp.spring.simplecontext.entity.impl.UserImpl;

public interface UserService {
	
	public UserImpl findUserByMail(String mail);

	public UserImpl findUserByPhone(String phone);
	
	public HashMap<String, String> signUp(UserImpl user);
	
	public HashMap<String, String> signIn(HashMap<String, String> loginData);
	
	public UserImpl UpdatePersonelInfos(UserImpl user, String mail);

	public boolean isMailExist(String mail);
	
	public boolean isMailValid(String mail);
	
	public boolean isPhoneExist(String phone);
	
	public boolean isPhoneValid(String phone);
	
	public boolean isLogin();
	
	public void setLogin(boolean login);
	
}

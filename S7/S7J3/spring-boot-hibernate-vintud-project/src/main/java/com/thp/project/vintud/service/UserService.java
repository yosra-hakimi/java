package com.thp.project.vintud.service;

import com.thp.project.vintud.entity.impl.UserImpl;

public interface UserService {


		public UserImpl getUserByMail(String email);

		public void updateUserInformations(String mail, String informationType, String newinformation);

		//public void createAccount(UserImpl newuser);
		public void createAccount(String firstname,String  name,String pseudo,String mail,String password,String phone,String address,int roleId) ;

		void addUser(UserImpl user);

	

}

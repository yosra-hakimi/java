package com.thp.project.vintud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.thp.project.vintud.dao.DaoUser;
import com.thp.project.vintud.entity.impl.UserImpl;
import com.thp.project.vintud.service.UserService;



@Transactional(propagation = Propagation.REQUIRES_NEW)
@Service
public class UserServiceImpl implements UserService  {
	
	 @Autowired
	    private DaoUser userDao;

	@Override
	public UserImpl getUserByMail(String email) {
		
		return userDao.getUserByMail(email);
	}

	@Override
	public void updateUserInformations(String mail, String informationType, String newinformation) {
		
		userDao.updateUserInformations(mail, informationType, newinformation);
	
		
	}

	@Override
	public void createAccount(String firstname, String name, String pseudo, String mail, String password, String phone,
			String address, int roleId) {
		
		userDao.createAccount(firstname, name, pseudo, mail, password, phone, address, roleId);
		
	}

	
	@Override
	public void addUser(UserImpl user) {
		userDao.createAccount(user);
		
	}
}


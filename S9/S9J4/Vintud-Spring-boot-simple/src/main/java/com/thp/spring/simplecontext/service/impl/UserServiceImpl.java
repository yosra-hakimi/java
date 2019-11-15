package com.thp.spring.simplecontext.service.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.thp.spring.simplecontext.Repository.UserRepository;
import com.thp.spring.simplecontext.config.SecureMyPassword;
import com.thp.spring.simplecontext.entity.impl.UserImpl;
import com.thp.spring.simplecontext.service.UserService;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public HashMap<String, String> signUp(UserImpl user) {
		HashMap<String, String> response = new HashMap<>();
		
		System.out.println("isMailValid" + isMailValid(user.getMail()));
		System.out.println("isPhoneValid" + isPhoneValid(user.getPhoneNumber()));
		System.out.println("isMailExist" + isMailExist(user.getMail()));
		System.out.println("isPhoneExist" + isPhoneExist(user.getPhoneNumber()));
		if (isMailValid(user.getMail()) == true && isPhoneValid(user.getPhoneNumber()) == true){	
			if(isMailExist(user.getMail()) == true || isPhoneExist(user.getPhoneNumber()) == true) {
				response.put("message", "email address or phone Number is used before");
			}
			else {
				user.setPassword(SecureMyPassword.securePassword(user.getPassword()));
				userRepository.save(user);
				response.put("message", "Welcome, your account was successfully created !");			
			}
		}
		return response;
	}

	@Override
	public HashMap<String, String> signIn(HashMap<String, String> loginData) {
		HashMap<String, String> response = new HashMap<>();
		System.out.println("checkMyPassword" + SecureMyPassword.checkMyPassword(loginData.get("password"), userRepository.findByMail(loginData.get("mail")).getPassword().trim()));
		if(	SecureMyPassword.checkMyPassword(loginData.get("password"), userRepository.findByMail(loginData.get("mail")).getPassword().trim())) {
			response.put("message", "You are logged in!");
		}
		else {
			response.put("message", "Connection Failure! please verify your mail and passsword");
		}
		
		return response;
	}

	@Override
	public UserImpl UpdatePersonelInfos(UserImpl user, String userMail) {
		/* Will be updated
		 * String response = ""; 
		 * if (isMailValid(user.getMail()) == true && isPhoneValid(user.getPhoneNumber()) == true){	
			if(isMailExist(user.getMail()) == true || isPhoneExist(user.getPhoneNumber()) == true) {
				response = "email address or phone Number is used before";
			}
			else {*/
				return userRepository.findById(user.getId())
						.map(u -> 
						{
							u.setName(user.getName()); 
							u.setFirstName(user.getFirstName());
							u.setPseudo(user.getPseudo());
							u.setAddress(user.getAddress());
							u.setMail(user.getMail());
							u.setPhoneNumber(user.getPhoneNumber());
							u.setPassword(user.getPassword());
							u.setRole(user.getRole());
							u.setAnnouncements(user.getAnnouncements());
							return userRepository.save(u);
						})
							.orElseGet(() -> {
						        user.setMail(userMail);
						        return userRepository.save(user);
						      });
		}

	@Override
	public boolean isMailExist(String mail) {
		
		return (userRepository.findByMail(mail) != null);
	}

	@Override
	public boolean isMailValid(String mail) {
	      String regex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	              + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	      return mail.matches(regex);

	}

	@Override
	public boolean isPhoneExist(String phone) {
		return (userRepository.findByPhone(phone) != null);
	}

	@Override
	public boolean isPhoneValid(String phone) {
		String regex = "^\\+?[0-9]{8,12}$";
		return (phone.matches(regex));
	}
	
	@Override
	public boolean isLogin() {
		return false;  // To be Implemented
	}

	@Override
	public void setLogin(boolean login) {
		// To be Implemented	
	}

	@Override
	public UserImpl findUserByMail(String mail) {
		return userRepository.findByMail(mail);
	}

	@Override
	public UserImpl findUserByPhone(String phone) {
		return userRepository.findByPhone(phone);
	}

	
}

package com.thp.spring.simplecontext.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thp.spring.simplecontext.entity.impl.UserImpl;
import com.thp.spring.simplecontext.service.UserService;

@CrossOrigin()
@Controller
public class UserController {
	
	
	@Autowired
	private UserService userService;
    
	@GetMapping(path ="/user/mail/{mail}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody UserImpl findUserByMail(@PathVariable("mail") String mail){
    	return userService.findUserByMail(mail);
    }
	
	@GetMapping(path ="/user/phone/{phone}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody UserImpl findUserByPhone(@PathVariable("phone") String phone){
    	return userService.findUserByPhone(phone);
    }
	
	@PostMapping(path="/signup", produces = MediaType.APPLICATION_JSON_VALUE)
	   public @ResponseBody HashMap<String, String> signUp (@RequestBody UserImpl user){
		return userService.signUp(user);
	   }
	
	@PostMapping(path="/signin", produces = MediaType.APPLICATION_JSON_VALUE)
	   public @ResponseBody HashMap<String, String> signIn (@RequestBody HashMap<String, String> loginData){
		return userService.signIn(loginData);
	   }
	
        
}

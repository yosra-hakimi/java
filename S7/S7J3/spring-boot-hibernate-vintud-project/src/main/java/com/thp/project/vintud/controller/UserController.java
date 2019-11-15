package com.thp.project.vintud.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.thp.project.vintud.entity.User;
import com.thp.project.vintud.entity.impl.UserImpl;
import com.thp.project.vintud.service.UserService;




@RestController
public class UserController {

	@Autowired
	private UserService userService ;
	
	/*
	 @GetMapping(path ="/user", produces = MediaType.APPLICATION_JSON_VALUE)
	   public @ResponseBody List<User> getAllUser(){
	       return userService.findAll();
	   }
	 */
	 
	 
	 
	 @GetMapping(path ="/user/{mail}", produces = MediaType.APPLICATION_JSON_VALUE)
	   public @ResponseBody UserImpl getUserByMailRest(@PathVariable("mail") String mail){
	    
	       return userService.getUserByMail(mail);
	       	  
	  }
	 
	 
	  @PostMapping(path = "/user/add", produces = MediaType.APPLICATION_JSON_VALUE)
	  public @ResponseBody Map<String, String> createUser(@RequestBody UserImpl newUser) {
		  
		  Map<String, String> ressMap = new HashMap<>();

			try {
				userService.addUser(newUser);
				ressMap.put("message", "successfully added");
			} catch (Exception e) {
				ressMap.put("error", "not added");
			} 
			
			return ressMap;
		}

	  
		  
	  
	 
	 
	  
	/*  
	  @PostMapping("/user/add")
	  public @ResponseBody int createMoussaillon (@RequestBody User user){
	    return userService.createMoussaillon(user);

	  }
	  
	  @PostMapping(path = "/user/add", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Map<String, String> create(@RequestBody UserImpl newUser) {
		
		Map<String, String> ressMap = new HashMap<>();

		try {
			uService.addUser(newUser);
			ressMap.put("message", "successfully added");
		} catch (Exception e) {
			ressMap.put("error", "not added");
		} 
		
		return ressMap;
	}

		@DeleteMapping(path = "/user/remove/{id}")
		public String delete(@PathVariable("id") int id) {

			userService.delete(id);
			 
			 return "le moussaillon "+ id +"a été supprimé avec succès";
			
		}

	  
	 */
	 
	 
	 
	 
}

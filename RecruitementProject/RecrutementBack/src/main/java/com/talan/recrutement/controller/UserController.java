package com.talan.recrutement.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.talan.recrutement.dto.UserDTO;
import com.talan.recrutement.service.UserService;

@Controller("/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/users")
	public @ResponseBody List<UserDTO> findAllUsers() {
		return userService.findAllUsers();
	}

	@PostMapping(path = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Map<String, String> createUser(@RequestBody UserDTO newUser) {
		userService.addUser(newUser);
		
		Map<String, String> varMap = new HashMap<>();
		varMap.put("response", "User is created successfully");
		
		
		return varMap;
	}

	@PostMapping(path = "/users/user", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String updateUser(@RequestBody UserDTO user) {
		userService.addUser(user);
		return "User is updated successfully";
	}

	@DeleteMapping(value = "/users/{mail}")
	public @ResponseBody String deleteUser(@PathVariable String mail) {
		userService.deleteUserByMail(mail);
		return "User is deleted successfully";
	}

	@GetMapping("/users/{mail}")
	public @ResponseBody UserDTO findUserByMail(@PathVariable String mail) {
		return userService.findUserById(mail);
	}

}

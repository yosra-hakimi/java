package com.talan.recrutement.service;

import java.util.List;

import com.talan.recrutement.dto.UserDTO;

public interface UserService {

	public UserDTO addUser(UserDTO newUser);

	public List<UserDTO> findAllUsers();

	public void deleteUserByMail(String userMail);

	public UserDTO findUserById(String userMail);

}

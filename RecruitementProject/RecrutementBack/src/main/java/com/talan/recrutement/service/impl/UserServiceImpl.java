package com.talan.recrutement.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.talan.recrutement.dto.UserDTO;
import com.talan.recrutement.helper.ModelMapperConverter;
import com.talan.recrutement.helper.PasswordEncryption;
import com.talan.recrutement.persistence.entity.UserEntity;
import com.talan.recrutement.persistence.repository.UserRepository;
import com.talan.recrutement.service.UserService;


@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	public List<UserDTO> findAllUsers() {
		List<UserEntity> users = (userRepository.findAll(Sort.by(Sort.Direction.ASC, "lastName")));
		return users.stream().map(user -> ModelMapperConverter.convertToDTO(user, UserDTO.class))
				.collect(Collectors.toList());
	}

	public UserDTO addUser(UserDTO newUser) {
		newUser.setPassword(PasswordEncryption.encryptionPass(newUser.getPassword()));
		UserEntity user = ModelMapperConverter.convertToEntity(newUser, UserEntity.class);
		UserEntity usercreated = userRepository.save(user);
		return ModelMapperConverter.convertToDTO(usercreated, UserDTO.class);
	}

	public void deleteUserByMail(String userMail) {
		userRepository.deleteById(userMail);

	}

	public UserDTO findUserById(String userMail) {
		Optional<UserEntity> user = userRepository.findById(userMail);
		if (user.isPresent()) {
			return ModelMapperConverter.convertToDTO(user.get(), UserDTO.class);
		} else {
			return null;
		}
	}

}

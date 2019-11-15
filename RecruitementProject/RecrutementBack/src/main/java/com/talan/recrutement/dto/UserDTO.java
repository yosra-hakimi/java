package com.talan.recrutement.dto;

import java.util.Date;

import com.talan.recrutement.persistence.entity.ProfileEntity;

import lombok.Data;

@Data
public class UserDTO extends ByblosDTO {

	private int id;
	private String mail;
	private String password;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String nationality;
	private Date dateOfBithday;
	private ProfileEntity profile;

}

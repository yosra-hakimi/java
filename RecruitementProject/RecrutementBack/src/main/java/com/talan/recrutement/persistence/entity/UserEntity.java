package com.talan.recrutement.persistence.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "userr")
public class UserEntity extends ByblosEntities implements Serializable {
	private static final long serialVersionUID = 1L;

	/********* Variables ********/

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Id
	@NotNull
	@Column(name = "mail")
	private String mail;

	@NotNull
	@Column(name = "password")
	private String password;

	@NotNull
	@Column(name = "first_name")
	private String firstName;

	@NotNull
	@Column(name = "last_name")
	private String lastName;

	@NotNull
	@Column(name = "phone_number")
	private String phoneNumber;

	@NotNull
	@Column(name = "nationality")
	private String nationality;

	@NotNull
	@Column(name = "date_of_bithday")
	private Date dateOfBithday;

	@NotNull
	@OneToOne()
	@JoinColumn(name = "profile_id")
	private ProfileEntity profile;
	
	

	
}

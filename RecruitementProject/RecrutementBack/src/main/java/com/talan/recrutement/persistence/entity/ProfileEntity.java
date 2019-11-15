package com.talan.recrutement.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "profile")
public class ProfileEntity extends ByblosEntities implements Serializable {
	private static final long serialVersionUID = 1L;

	/********* Variable ********/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	
	@Column(name = "profile_name")
	private String profileName;

	@OneToOne
	@JoinColumn(name = "role_id")
	private RoleEntity role ;

	
}

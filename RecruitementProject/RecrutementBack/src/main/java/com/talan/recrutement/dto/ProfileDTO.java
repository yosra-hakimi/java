package com.talan.recrutement.dto;

import com.talan.recrutement.persistence.entity.RoleEntity;

import lombok.Data;

@Data
public class ProfileDTO extends ByblosDTO {
	private int id;
	private String profileName;
	private RoleEntity role;
}

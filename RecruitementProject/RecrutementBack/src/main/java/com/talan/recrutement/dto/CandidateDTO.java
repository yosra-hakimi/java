package com.talan.recrutement.dto;

import java.util.Date;

import com.talan.recrutement.persistence.entity.ApplicationEntity;
import com.talan.recrutement.persistence.entity.DiplomaEntity;

import lombok.Data;

@Data
public class CandidateDTO extends ByblosDTO {

	private int id;
	private String statut;
	private String civility;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String mail;
	private String nationality;
	private Date dateOfBithday;
	private String typeIdentityPiece;
	private Date expirationIdentityPiece;
	private String numIdentityPiece;
	private Date dateFirstExperience;
	private String entreprise;
	private ApplicationEntity application;
	private DiplomaEntity diploma;
	private String processId;
	
	
}

package com.talan.recrutement.persistence.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "candidate")
public class CandidateEntity extends ByblosEntities implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	/********* Variables ********/

	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "statut")
	private String statut;

	@Column(name = "civility")
	private String civility;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Id
	@Column(name = "mail")
	private String mail;

	@Column(name = "nationality")
	private String nationality;

	@Column(name = "date_of_bithday")
	private Date dateOfBithday;

	@Column(name = "type_identity_piece" )
	private String typeIdentityPiece;

	@Column(name = "expiration_identity_piece" )
	private Date expirationIdentityPiece;

	@Column(name = "num_identity_piece" )
	private String numIdentityPiece;

	@Column(name = "date_first_experience")
	private Date dateFirstExperience;

	@Column(name = "entreprise")
	private String entreprise;
	
	@Column(name="process_id")
	private String processId;

	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "application_id")
	private ApplicationEntity application;
	
	
	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name = "diploma_id")
	
	private DiplomaEntity diploma ;
	
	
	


}

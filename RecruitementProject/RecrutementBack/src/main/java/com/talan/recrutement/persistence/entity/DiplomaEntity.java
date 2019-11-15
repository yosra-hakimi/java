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
@Table(name = "diploma")
public class DiplomaEntity extends ByblosEntities implements Serializable  {
	private static final long serialVersionUID = 1L;
	
	/********* Variables ********/

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "formation")
	private String formation;
	
	@Column(name = "actuel_post")
	private String actuelPost;

	
	@OneToOne
	@JoinColumn(name = "university_id")
	private UniversityEntity university ;
	

	
	
}


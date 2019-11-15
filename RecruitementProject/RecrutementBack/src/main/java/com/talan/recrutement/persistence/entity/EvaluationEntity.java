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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "evaluation")
public class EvaluationEntity  extends ByblosEntities implements Serializable  {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "opinion")
	private String opinion;
	
	@Column(name = "comment")
	private String comment;
	
	@Column(name = "nextStep")
	private String nextStep;
	
	@Column(name = "Date")
	private Date Date;
	
	@Column(name = "statut")
	private String statut;
	
	@Column(name = "currentRenumeration")
	private float currentRemuneration;
	
	@Column(name = "desiredRenumeration")
	private float desiredRemuneration;
	
	
}

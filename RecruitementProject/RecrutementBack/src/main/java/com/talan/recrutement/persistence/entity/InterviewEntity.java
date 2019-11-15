package com.talan.recrutement.persistence.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "interview")
public class InterviewEntity extends ByblosEntities implements Serializable {
	private static final long serialVersionUID = 1L;

	/********* Variables ********/

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int id;

	@Column(name = "interviewDate")
	private Date interviewDate;

	@Column(name = "interviewType", nullable = false)
	private String interviewType;

	@Column(name = "businessUnit", nullable = false)
	private String businessUnit;

	@Column(name = "jobOffer", nullable = false)
	private String jobOffer;

	@Column(name = "opinion")
	private String opinion;

	@Column(name = "comment")
	private String comment;

	@Column(name = "Date")
	private Date Date;

	@Column(name = "statut")
	private String statut;

	@Column(name = "currentRenumeration")
	private float currentRemuneration;

	@Column(name = "desiredRenumeration")
	private float desiredRemuneration;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "interviewer_id")
	private UserEntity interviewWith;

}

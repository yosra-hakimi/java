package com.talan.recrutement.dto;





import java.util.Date;

import com.talan.recrutement.persistence.entity.ApplicationEntity;
import com.talan.recrutement.persistence.entity.EvaluationEntity;
import com.talan.recrutement.persistence.entity.UserEntity;

import lombok.Data;

@Data
public class InterviewDTO extends ByblosDTO {

	private int id;

	private Date interviewDate;

	private String interviewType;

	private String businessUnit;

	private String jobOffer;
	
	private String opinion;
	
	private String comment;
	
	
	private Date Date;
	
	private String statut;
	
	private float currentRemuneration;
	
	private float desiredRemuneration;

	private UserEntity interviewWith;

	private ApplicationEntity applicationInterview;
	
	

	/* private EvaluationEntity evaluationInterview; */


	@Override
	public String toString() {
		return "InterviewDTO [id=" + id + ", interviewDate=" + interviewDate + ", interviewType=" + interviewType
				+ ", businessUnit=" + businessUnit + ", jobOffer=" + jobOffer + ", interviewWith=" + interviewWith
				+ ", applicationInterview=" + applicationInterview + ", evaluationInterview=" 
				+ "]";
	}
	
	

}

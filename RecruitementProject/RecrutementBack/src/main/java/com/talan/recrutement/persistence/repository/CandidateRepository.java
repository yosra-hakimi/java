package com.talan.recrutement.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.talan.recrutement.dto.CandidateDTO;
import com.talan.recrutement.persistence.entity.CandidateEntity;

public interface CandidateRepository
		extends JpaRepository<CandidateEntity, String>, JpaSpecificationExecutor<CandidateEntity> {
	
	
	public List<CandidateEntity> findByApplicationInterviewInterviewWithMail(String mail);
	}

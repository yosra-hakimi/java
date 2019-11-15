package com.talan.recrutement.service;

import java.util.List;

import com.talan.recrutement.dto.ApplicationDTO;
import com.talan.recrutement.dto.CandidateDTO;
import com.talan.recrutement.dto.DiplomaDTO;

public interface CandidateService {

	public CandidateDTO createCandidate(CandidateDTO newCandidate);

	public ApplicationDTO createApplication(ApplicationDTO newApplication);

	public DiplomaDTO createDiploma(DiplomaDTO newDiploma);

	public CandidateDTO update(CandidateDTO candidateToUpdate);
	
	public CandidateDTO getCandidateByMail(String mail);

	List<CandidateDTO> findListInterviewsByUser(String mail);

}

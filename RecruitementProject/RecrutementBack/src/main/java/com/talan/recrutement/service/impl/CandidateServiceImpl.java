package com.talan.recrutement.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.talan.recrutement.dto.ApplicationDTO;
import com.talan.recrutement.dto.CandidateDTO;
import com.talan.recrutement.dto.DiplomaDTO;
import com.talan.recrutement.helper.ModelMapperConverter;
import com.talan.recrutement.persistence.entity.ApplicationEntity;
import com.talan.recrutement.persistence.entity.CandidateEntity;
import com.talan.recrutement.persistence.entity.DiplomaEntity;
import com.talan.recrutement.persistence.repository.ApplicationRepository;
import com.talan.recrutement.persistence.repository.CandidateRepository;
import com.talan.recrutement.persistence.repository.DiplomaRepository;
import com.talan.recrutement.service.CandidateService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class CandidateServiceImpl implements CandidateService {

	@Autowired
	private DiplomaRepository DiplomaDAO;

	@Autowired
	private CandidateRepository CandidateDAO;

	@Autowired
	private ApplicationRepository ApplicationDAO;

	public CandidateDTO createCandidate(CandidateDTO newCandidate) {

		CandidateEntity candidate = ModelMapperConverter.convertToEntity(newCandidate, CandidateEntity.class);
		CandidateEntity candidatecreated = CandidateDAO.save(candidate);
		return ModelMapperConverter.convertToDTO(candidatecreated, CandidateDTO.class);
	}
	
	
	public void deleteCandidateByMail(String mail) {

		CandidateDAO.deleteById(mail);
		
	}

	public ApplicationDTO createApplication(ApplicationDTO newApplication) {

		ApplicationEntity application = ModelMapperConverter.convertToEntity(newApplication, ApplicationEntity.class);
		ApplicationEntity applicationcreated = ApplicationDAO.save(application);
		return ModelMapperConverter.convertToDTO(applicationcreated, ApplicationDTO.class);
	}

	public DiplomaDTO createDiploma(DiplomaDTO newDiploma) {

		DiplomaEntity diploma = ModelMapperConverter.convertToEntity(newDiploma, DiplomaEntity.class);
		DiplomaEntity diplomacreated = DiplomaDAO.save(diploma);
		return ModelMapperConverter.convertToDTO(diplomacreated, DiplomaDTO.class);
	}

	@Override
	public CandidateDTO update(CandidateDTO candidateToUpdate) {

		CandidateEntity candidate = ModelMapperConverter.convertToEntity(candidateToUpdate, CandidateEntity.class);
		CandidateEntity candidatecreated = CandidateDAO.save(candidate);
		return ModelMapperConverter.convertToDTO(candidatecreated, CandidateDTO.class);
	}

	public CandidateDTO getCandidateByMail(String mail) {
		CandidateEntity candidateEntity = CandidateDAO.findById(mail).get();

		return ModelMapperConverter.convertToDTO(candidateEntity, CandidateDTO.class);
	}

	@Override
	public List<CandidateDTO> findListInterviewsByUser(String mail) {
		List<CandidateEntity> userEntities = CandidateDAO.findByApplicationInterviewInterviewWithMail(mail);
		return userEntities.stream().distinct()
				.map(candidate -> ModelMapperConverter.convertToDTO(candidate, CandidateDTO.class))
				.collect(Collectors.toList());
	}
	
	
	public List<CandidateDTO> findAllCandidate(){
		List<CandidateEntity> candidatsList = CandidateDAO.findAll();
		
		return candidatsList.stream().distinct()
				.map(candidate -> ModelMapperConverter.convertToDTO(candidate, CandidateDTO.class))
				.collect(Collectors.toList());
		
	}

}

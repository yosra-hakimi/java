package com.talan.recrutement.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.talan.recrutement.dto.ApplicationDTO;
import com.talan.recrutement.dto.InterviewDTO;
import com.talan.recrutement.dto.UserDTO;
import com.talan.recrutement.helper.ModelMapperConverter;
import com.talan.recrutement.persistence.entity.ApplicationEntity;
import com.talan.recrutement.persistence.entity.UserEntity;
import com.talan.recrutement.persistence.repository.ApplicationRepository;
import com.talan.recrutement.service.ApplicationService;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class ApplicationServiceImpl implements ApplicationService {

	@Autowired
	private ApplicationRepository applicationRepository;
	

	@Override
	public List<ApplicationDTO> findAll() {
		List<ApplicationEntity> applications = applicationRepository.findAll();
		return applications.stream().map(application -> ModelMapperConverter.convertToDTO(application, ApplicationDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public ApplicationDTO findApplicationById(int id) {
		ApplicationEntity applicationEntity = this.applicationRepository.findById(id).get();
		return ModelMapperConverter.convertToDTO(applicationEntity, ApplicationDTO.class);
	}

	@Override
	public ApplicationDTO findInterviewsByCandidat(String email) {

		ApplicationEntity applicationEntity = applicationRepository.findAll().get(0);
		return ModelMapperConverter.convertToDTO(applicationEntity, ApplicationDTO.class);
		
	}

	@Override
	public List<ApplicationDTO> getAllApplication() {
		List<ApplicationEntity> candidats = applicationRepository.findAll();
		return candidats.stream().map(candidat -> ModelMapperConverter.convertToDTO(candidat, ApplicationDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public ApplicationDTO addInterview(ApplicationDTO newApplication) {
		ApplicationEntity application = ModelMapperConverter.convertToEntity(newApplication, ApplicationEntity.class);
		ApplicationEntity applicationEntity = applicationRepository.save(application);
		return ModelMapperConverter.convertToDTO(applicationEntity, ApplicationDTO.class);
	}


}

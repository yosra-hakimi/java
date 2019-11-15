package com.talan.recrutement.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.talan.recrutement.dto.InterviewDTO;
import com.talan.recrutement.dto.UniversityDTO;
import com.talan.recrutement.helper.ModelMapperConverter;
import com.talan.recrutement.persistence.entity.InterviewEntity;
import com.talan.recrutement.persistence.entity.UniversityEntity;
import com.talan.recrutement.persistence.repository.UniversityRepository;
import com.talan.recrutement.service.UniversityService;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class UniversityServiceImpl implements UniversityService {

	@Autowired
	private UniversityRepository universityRepository;

	public List<UniversityDTO> findAllUniversity() {
		List<UniversityEntity> universities = (universityRepository.findAll());
		return universities.stream()
				.map(university -> ModelMapperConverter.convertToDTO(university, UniversityDTO.class))
				.collect(Collectors.toList());
	}

	public UniversityDTO addUniversity(UniversityDTO newUniversity) {

		UniversityEntity university = ModelMapperConverter.convertToEntity(newUniversity, UniversityEntity.class);
		UniversityEntity universitycreated = universityRepository.save(university);
		return ModelMapperConverter.convertToDTO(universitycreated, UniversityDTO.class);
	}

	
	public void deleteUniversityById(int id) {
		universityRepository.deleteById(id);

	}

}

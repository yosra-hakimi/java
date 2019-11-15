package com.talan.recrutement.service;

import java.util.List;

import com.talan.recrutement.dto.UniversityDTO;
import com.talan.recrutement.persistence.entity.UniversityEntity;

public interface UniversityService {

	public List<UniversityDTO> findAllUniversity();

	public UniversityDTO addUniversity(UniversityDTO newUniversity);


	public void deleteUniversityById(int id);

}

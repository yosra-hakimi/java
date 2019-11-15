package com.talan.recrutement.service;

import java.util.List;

import com.talan.recrutement.dto.ApplicationDTO;

public interface ApplicationService {

    public List<ApplicationDTO> findAll();

    public ApplicationDTO findApplicationById(int id);

    public ApplicationDTO findInterviewsByCandidat(String email);
    
    public List<ApplicationDTO> getAllApplication();

	public ApplicationDTO addInterview(ApplicationDTO applicationEntity);
    
}
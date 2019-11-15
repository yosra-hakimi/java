package com.talan.recrutement.service;

import java.util.List;

import com.talan.recrutement.dto.InterviewDTO;

public interface InterviewService {

	public List<InterviewDTO> findAllInterviews();

	public InterviewDTO findInterviewById(int id);

	public InterviewDTO addInterview(InterviewDTO newInterview);
	
	public void deleteInterview(int id);
	

}

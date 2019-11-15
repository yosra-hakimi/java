package com.talan.recrutement.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.talan.recrutement.dto.ApplicationDTO;
import com.talan.recrutement.persistence.entity.ApplicationEntity;
import com.talan.recrutement.service.ApplicationService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ApplicationController {

	@Autowired
	private ApplicationService applicationService;
	

	@GetMapping(path = "/applications/{candidateEmail}/interviews", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ApplicationDTO findintervInterviewsByCandidateEmail(
			@PathVariable("candidateEmail") String candidatId) {
		return applicationService.findInterviewsByCandidat(candidatId);
	}

	@GetMapping(path = "/applications", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<ApplicationDTO> findAllApplications() {
		return applicationService.getAllApplication();
	}
	
	@PostMapping(path = "/applications", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Map<String,String> AddEvaluationToInterviewApplication(@RequestBody ApplicationDTO applicationDTO) {
		 applicationService.addInterview(applicationDTO);
		 
		 Map<String,String> varMap =new HashMap<>();
		 varMap.put("response", "application updated succesfully");
		 return varMap;
	}



}

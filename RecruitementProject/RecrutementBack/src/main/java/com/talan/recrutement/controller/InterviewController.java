package com.talan.recrutement.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.talan.recrutement.dto.InterviewDTO;
import com.talan.recrutement.service.InterviewService;

@RestController()
@CrossOrigin(origins = "http://localhost:4200")
public class InterviewController {

	@Autowired
	private InterviewService interviewService;

	@GetMapping(path = "/interviews", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<InterviewDTO> getAll() {
		return interviewService.findAllInterviews();
		
	}
	

	@PostMapping(path = "/interviews/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Map<String, String> updateInterview(@RequestBody InterviewDTO updatedInterview) {
		interviewService.addInterview(updatedInterview);
		
		Map<String, String> response =  new HashMap<String,String>();
		response.put("response","Interview is updated successfully");
		
		return response;
	}

	@DeleteMapping(path = "/interviews/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Map<String, String> deleteInterview(@PathVariable int id) {
		interviewService.deleteInterview(id);

		Map<String, String> response =  new HashMap<String,String>();
		response.put("response","Interview is deleted successfully");
		
		return response;
	}

	@PostMapping(path = "/interviews", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Map<String, String> addInterview(@RequestBody InterviewDTO updatedInterview) {
		interviewService.addInterview(updatedInterview);
		
		Map<String, String> response =  new HashMap<String,String>();
		response.put("response","Interview is updated successfully");
		
		return response;
	}
	
	
}

package com.talan.recrutement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.talan.recrutement.dto.UniversityDTO;
import com.talan.recrutement.service.UniversityService;

@Controller("/university")
public class UniversityController {
	@Autowired
	UniversityService universityService;

	@GetMapping("/university")
	public @ResponseBody List<UniversityDTO> findAllUniversity() {
		return universityService.findAllUniversity();
	}

	@PostMapping(path = "/university", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String createUniversity(@RequestBody UniversityDTO newUniversity) {
		universityService.addUniversity(newUniversity);
		return "University is created successfully";
	}

	@DeleteMapping(value = "/university/{id}")
	public @ResponseBody String deleteUniversity(@PathVariable int id) {
		universityService.deleteUniversityById(id);
		return "University is deleted successfully";
	}

}

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

import com.talan.recrutement.dto.ProfileDTO;
import com.talan.recrutement.service.ProfileService;

@Controller("/profiles")
public class ProfileController {

	@Autowired
	ProfileService profileService;

	@GetMapping("/profiles")
	public @ResponseBody List<ProfileDTO> findAllProfiles() {
		return profileService.findAllProfiles();
	}

	@PostMapping(path = "/profiles", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String createProfile(@RequestBody ProfileDTO newProfile) {
		profileService.addProfile(newProfile);
		return "Profil is created successfully";
	}

	@PostMapping(path = "/profiles/profile", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String updateProfile(@RequestBody ProfileDTO profile) {
		profileService.addProfile(profile);
		return "Profil is updated successfully";
	}

	@DeleteMapping(value = "/profiles/{name}")
	public @ResponseBody String deleteProfile(@PathVariable String name) {
		profileService.deleteProfileByName(name);
		return "Profil is deleted successfully";
	}

	@GetMapping("/profiles/{name}")
	public @ResponseBody ProfileDTO findProfileByName(@PathVariable String name) {
		return profileService.findProfileByName(name);
	}
}

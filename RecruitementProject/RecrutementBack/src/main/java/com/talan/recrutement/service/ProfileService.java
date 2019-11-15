package com.talan.recrutement.service;

import java.util.List;

import com.talan.recrutement.dto.ProfileDTO;

public interface ProfileService {

	public ProfileDTO addProfile(ProfileDTO newUser);

	public List<ProfileDTO> findAllProfiles();

	public void deleteProfileByName(String profileName);

	public ProfileDTO findProfileByName(String profileName);
}

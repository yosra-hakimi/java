package com.talan.recrutement.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.talan.recrutement.dto.ProfileDTO;
import com.talan.recrutement.helper.ModelMapperConverter;
import com.talan.recrutement.persistence.entity.ProfileEntity;
import com.talan.recrutement.persistence.repository.ProfileRepository;
import com.talan.recrutement.service.ProfileService;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class ProfileServiceImpl implements ProfileService {

	@Autowired
	private ProfileRepository profileRepository;

	public List<ProfileDTO> findAllProfiles() {
		List<ProfileEntity> profiles = (profileRepository.findAll());
		return profiles.stream().map(profile -> ModelMapperConverter.convertToDTO(profile, ProfileDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public ProfileDTO addProfile(ProfileDTO newProfile) {
		ProfileEntity profile = ModelMapperConverter.convertToEntity(newProfile, ProfileEntity.class);
		ProfileEntity profilecreated = profileRepository.save(profile);
		return ModelMapperConverter.convertToDTO(profilecreated, ProfileDTO.class);
	}

	@Override
	public void deleteProfileByName(String profileName) {
		profileRepository.deleteById(profileName);
	}

	@Override
	public ProfileDTO findProfileByName(String profileName) {
		Optional<ProfileEntity> profile = profileRepository.findById(profileName);
		if (profile.isPresent()) {
			return ModelMapperConverter.convertToDTO(profile.get(), ProfileDTO.class);
		} else {
			return null;
		}
	}

}

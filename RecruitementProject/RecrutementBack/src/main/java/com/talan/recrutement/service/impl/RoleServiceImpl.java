package com.talan.recrutement.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.talan.recrutement.dto.RoleDTO;
import com.talan.recrutement.helper.ModelMapperConverter;
import com.talan.recrutement.persistence.entity.RoleEntity;
import com.talan.recrutement.persistence.repository.RoleRepository;
import com.talan.recrutement.service.RoleService;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;

	public List<RoleDTO> findAllRoles() {
		List<RoleEntity> roles = (roleRepository.findAll());
		return roles.stream().map(role -> ModelMapperConverter.convertToDTO(role, RoleDTO.class))
				.collect(Collectors.toList());
	}

	public RoleDTO addRole(RoleDTO newRole) {
		RoleEntity role = ModelMapperConverter.convertToEntity(newRole, RoleEntity.class);
		RoleEntity rolecreated = roleRepository.save(role);
		return ModelMapperConverter.convertToDTO(rolecreated, RoleDTO.class);
	}

	public void deleteRoleByName(String name) {
		roleRepository.deleteById(name);

	}

	public RoleDTO findRoleByName(String name) {
		Optional<RoleEntity> role = roleRepository.findById(name);
		if (role.isPresent()) {
			return ModelMapperConverter.convertToDTO(role.get(), RoleDTO.class);
		} else {
			return null;
		}
	}
}

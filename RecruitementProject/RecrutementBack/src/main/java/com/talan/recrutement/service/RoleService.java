package com.talan.recrutement.service;

import java.util.List;

import com.talan.recrutement.dto.RoleDTO;

public interface RoleService {

	public List<RoleDTO> findAllRoles();

	public RoleDTO addRole(RoleDTO newRole);

	public void deleteRoleByName(String name);

	public RoleDTO findRoleByName(String name);
}

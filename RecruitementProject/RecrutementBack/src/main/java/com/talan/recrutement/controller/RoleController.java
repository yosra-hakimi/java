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

import com.talan.recrutement.dto.RoleDTO;
import com.talan.recrutement.service.RoleService;

@Controller("/roles")
public class RoleController {

	@Autowired
	RoleService roleService;

	@GetMapping("/roles")
	public @ResponseBody List<RoleDTO> findAllRoles() {
		return roleService.findAllRoles();
	}

	@PostMapping(path = "/roles", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String createRole(@RequestBody RoleDTO newRole) {
		roleService.addRole(newRole);
		return "Role is created successfully";
	}

	@PostMapping(path = "/roles/role", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String updateRole(@RequestBody RoleDTO role) {
		roleService.addRole(role);
		return "Role is updated successfully";
	}

	@DeleteMapping(value = "/roles/{name}")
	public @ResponseBody String deleteRole(@PathVariable String name) {
		roleService.deleteRoleByName(name);
		return "Role is deleted successfully";
	}

	@GetMapping("/roles/{name}")
	public @ResponseBody RoleDTO findRoleByName(@PathVariable String name) {
		return roleService.findRoleByName(name);
	}
}

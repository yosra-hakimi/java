package com.thp.spring.simplecontext.entity.impl;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.thp.spring.simplecontext.entity.Role;

@Entity
@Table(name="role", schema = "public")

public class RoleImpl implements Role, Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name")
	private String roleName;

	public RoleImpl() {

	}

	public RoleImpl(Integer id, String roleName) {
		
		this.id = id;
		this.roleName = roleName;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoleName()
	{
		return roleName;
	}

	public void setRoleName(String roleName)
	{
		this.roleName = roleName;
	}

	public String toString()
	{
		return "RoleImpl [roleName=" + roleName + "]";
	}

}

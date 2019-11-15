package com.thp.project.vintud.entity.impl;

import com.thp.project.vintud.entity.Role;

public class RoleImpl implements Role{

	private int id;
	private String nom;

	public RoleImpl(int id, String nom) {
		this.id = id;
		this.nom = nom;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}

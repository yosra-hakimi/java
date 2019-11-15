package com.thp.spring.simplecontext.entity.impl;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.thp.spring.simplecontext.entity.Search;


@Entity
@Table(name="Recherche", schema = "public")
public class SearchImpl implements Search, Serializable{
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int    id;
	
	@Column(name="habit")
	private String habit;
	
	@Column(name="taille")
	private String taille;
	
	@Column(name="couleur")
	private String couleur;
	
	@Column(name="fourchettePrix")
	private String fourchettePrix;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	private UserImpl user;

	public SearchImpl()
	{

	}

	public SearchImpl(int id, String habit, String taille, String couleur, String fourchettePrix, UserImpl user) {

		this.id = id;	
		this.habit=habit;
		this.taille=taille;
		this.couleur=couleur;
		this.fourchettePrix=fourchettePrix;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHabit() {
		return habit;
	}

	public void setHabit(String habit) {
		this.habit = habit;
	}

	public String getTaille() {
		return taille;
	}

	public void setTaille(String taille) {
		this.taille = taille;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public String getFourchettePrix() {
		return fourchettePrix;
	}

	public void setFourchettePrix(String fourchettePrix) {
		this.fourchettePrix = fourchettePrix;
	}

	public UserImpl getUser() {
		return user;
	}

	public void setUser(UserImpl user) {
		this.user = user;
	}

}

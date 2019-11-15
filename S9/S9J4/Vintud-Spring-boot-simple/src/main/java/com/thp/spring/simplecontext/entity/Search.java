package com.thp.spring.simplecontext.entity;

import com.thp.spring.simplecontext.entity.impl.UserImpl;

public interface Search {
	
	
	public int getId();

	public void setId(int id) ;
	
	public String getHabit();

	public void setHabit(String habit);

	public String getTaille();

	public void setTaille(String taille);

	public String getCouleur();

	public void setCouleur(String couleur);

	public String getFourchettePrix();

	public void setFourchettePrix(String fourchettePrix);

	public UserImpl getUser();

	public void setUser(UserImpl user);

}

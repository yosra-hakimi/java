package com.thp.simplecontext.entity;

import java.io.Serializable;

public class Moussaillon implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String firstName ;
	private String lastName;
	private String config;
	private Bateau bateau ;
	private int bateau_id;
	
	
	/*
	public Moussaillon(String firstName, String lastName, String config) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.config = config;
	}
	*/
	public Moussaillon() {
		
	}
	

	public Moussaillon(int id, String firstName, String lastName, String config, Bateau bateau) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.config = config;
		this.bateau = bateau;
	}




	public Bateau getBateau() {
		return bateau;
	}


	public void setBateau(Bateau bateau) {
		this.bateau = bateau;
	}


	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getConfig() {
		return config;
	}
	public void setConfig(String config) {
		this.config = config;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
 
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}  
	
    public void afficher(){  
        System.out.println( "Le pr�nom du moussaillon :"+" "+ firstName); 
        System.out.println("Le nom du moussaillon :"+" "+lastName);
        System.out.println("Configuration utilis�e :"+" "+config);
        
        
        
    }

	
	@Override
	public String toString() {
		return "Moussaillon [id=" + id +", firstName=" + firstName.trim() + ", lastName=" + lastName.trim() + ", config=" + config.trim()
				+ ", bateau=" + bateau + "]";
	}


	public int getBateau_id() {
		return bateau_id;
	}


	public void setBateau_id(int bateau_id) {
		this.bateau_id = bateau_id;
	}
    
    
}
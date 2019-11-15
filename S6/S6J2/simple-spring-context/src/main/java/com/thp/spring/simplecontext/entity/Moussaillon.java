package com.thp.spring.simplecontext.entity;

public class Moussaillon {
	
	private int id;
	private String firstName ;
	private String lastName;
	private String config;
	private Bateau bateau ;
	
	
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
        System.out.println( "Le prénom du moussaillon :"+" "+ firstName); 
        System.out.println("Le nom du moussaillon :"+" "+lastName);
        System.out.println("Configuration utilisée :"+" "+config);
        
        
        
    }

	
	@Override
	public String toString() {
		return "Moussaillon [id=" + id +", firstName=" + firstName.trim() + ", lastName=" + lastName.trim() + ", config=" + config.trim()
				+ ", bateau=" + bateau + "]";
	}
    
    
}
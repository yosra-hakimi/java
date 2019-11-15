package com.thp.spring.simplecontext;

public class Moussaillon {
	private String firstName ;
	private String lastName;
	private String config;
	
	
	public Moussaillon(String firstName, String lastName, String config) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.config = config;
	}
	
	public Moussaillon() {
	
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
	
    
    void afficher(){  
        System.out.println( "Le prénom du moussaillon :"+" "+ firstName); 
        System.out.println("Le nom du moussaillon :"+" "+lastName);
        System.out.println("Configuration utilisée :"+" "+config);
        
        
        
    }  
}
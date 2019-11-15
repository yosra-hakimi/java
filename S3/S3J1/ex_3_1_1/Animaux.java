package ex_3_1_1; 

import java.util.ArrayList;
import java.util.Collections;



public class Animaux {
	
    private ArrayList<String> tabAnimaux ;
	private  String nom ;

	public  Animaux(String nom){
		this.nom = nom ;	
		this.tabAnimaux =  new ArrayList<String>();
	}
	
	public  Animaux(){
		this.tabAnimaux =  new ArrayList<String>();
	}
	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}

	
	public void ajout(String an){
		this.tabAnimaux.add(an);
	      
	}
	
	
	public void affiche () {

		for (String an : this.tabAnimaux) 
			System.out.print(an +" ");
		System.out.print("\n");
			
	}
	
	public void supprime(int i) {
		   this.tabAnimaux.remove(i); 
		  
	 }
	   
	 public void supprime(String nom ) {
		   this.tabAnimaux.remove(nom); 
		  
	 }
	   public int taille( ) {
		return   this.tabAnimaux.size();
		   
		   
	  }
	   
	   public void searchByIndex(int index ) {
		 
			System.out.println(this.tabAnimaux.get(index));
		
		}
	   
	public void searchByName(String nom ) {
		 System.out.println(this.tabAnimaux.indexOf(nom));
	
	}
	
	public void sort() {
		 Collections.sort(this.tabAnimaux); 
	System.out.println("List after the use of" + " Collection.sort() :\n" +this.tabAnimaux); 

	}
	
	public void ArraySort() {
		
		this.tabAnimaux.sort(null);
		System.out.println("List after the use of" + " Collection.sort() :\n" +this.tabAnimaux); 
		
	}
	
	
	
		public int compare(String s1, String s2) {
			
         int len1=s1.length();
         int len2=s2.length();
         if(len1>len2) {
        	 return 1;
         }
         if(len1<len2) {
        	 return -1;
         }
         else return 0;
 	 
	   }
					
		
		public int compareto(String s1, String s2) {
			
        return s1.compareTo(s2);
 	 
	   }

	

       
	
}




	   
	
	
	



package ex_3_1_1;

import java.util.ArrayList;
import java.util.List;

public class Main {

	 

	public static void main(String[] args) {

	
		
		ArrayList<String> an = new ArrayList<String>();
			an.add("Lion");
			an.add("Tiger");
			an.add("Cat");
			an.add("Dog");		               
	        	System.out.println(an);
	        	//[Lion, Tiger, Cat, Dog]
	        	an.add(2,"Elephant");	
	        	System.out.println(an);
	        	//[Lion, Tiger, Elephant, Cat, Dog]
	         
	         
	         List<String> list = new ArrayList<String>(an);
	         list.add("Lion");
	         list.add("Tiger");
	         list.add(" Elephant");
	         list.add("Cat");
	         list.add(" Dog");  
	         System.out.println(list);
	         //[Lion, Tiger, Elephant, Cat, Dog, Lion, Tiger,  Elephant, Cat,  Dog]
	         System.out.println(list.size());
	         list.remove(0);
	         System.out.println(list);
	         System.out.println(list.size());
	         
	       
	         
	     
	     	Animaux anim = new Animaux("Lion");
			
			anim.ajout("Lion");
			anim.ajout("Tiger");
			anim.ajout("Elephant");
			anim.ajout("cat");
			anim.ajout("Dog");
			anim.affiche();
			System.out.println("\n apres supression par indice");
			anim.supprime(4);
			anim.affiche();
			anim.supprime("Tiger");
			System.out.println("\n apres supression par nom ");
			anim.affiche();
			System.out.println("\n Nouveau tableau ");
			
			Animaux animal = new Animaux();
			
			animal.ajout("Lion");
			animal.ajout("Elephant");
			animal.ajout("Cat");
			animal.ajout("Dog");
			animal.ajout("Lion");
			animal.ajout(" Elephant");
			animal.ajout(" Cat");
			animal.ajout(" Dog");
			animal.affiche();
			System.out.println(animal.taille()-1);
			animal.searchByIndex(1);
			animal.searchByName("Cat");
			animal.searchByName("Dog");
			animal.searchByName("DOG");	
			animal.sort();
			animal.ArraySort();

	   	  }
	   	  
	         

	}

	







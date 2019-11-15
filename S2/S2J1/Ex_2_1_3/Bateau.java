
public class Bateau {
	private static int nId=0;
	
	private Cabine c;
    private Pont p;
    private Coque q;

	
	
	
private int vie;
private String nom ;
public int id ;




 //getters accesseurs
public int getVie() {
return this.vie;
} 
  public String getNom(){
	 
	 return this.nom ;
 }
   public int getId(){
	 
	 return this.id ;
 }
 
 //setters modificateurs
 
 public void setVie(int vie){
	 
	 this.vie = vie ;
 }
 
   public void setNom(String nom){
	 
	 this.nom = nom ;
 }
 
   public void setId(int id){
	 
	this.id = id ;
 }
 
 

public Bateau() {
	 id = nId;
        nId++;

	
this.nom = "Pirate" ;
//this.id=1;
}
public Bateau(int longueur,Cabine c,Pont p,Coque q) {
	 this.p=p;
    this.q=q;
    this.id = nId;
    nId++;

	
	
this.vie = longueur;
}

public boolean estCoule() {
return this.vie <= 0;
}

public void touche() {
this.vie = this.vie - 1;


	
}

public String toString() {
    return ("Le bateau n° "+ this.id + " est constitué de : \n" + "La coque n°" + this.q.toString()+";\n"+"La cabine n°" + this.c.toString()+";\n"+"Le pont n°"+this.p.toString()+"est consituté du Mat n°");
}




}

		
	

	
	
	

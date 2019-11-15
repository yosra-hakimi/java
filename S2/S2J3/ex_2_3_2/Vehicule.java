

 abstract public class Vehicule {
	  
	  
	  //Attribut de l'objet

 //Ces attributs sont private pour assurer une bonne encapsulation	
	 protected int  matricule;
	 protected int annee;
	protected double  prix ;
	 protected int puissance;

	 
	
	 //Variable de classe
	//Variables dont il n’existe qu’un seul exemplaire 
	//associé à sa classe de définition
	
     private static int nb_vehicules = 0;

	 
	 //Définition d'un constructeur
	 
	  public Vehicule(){
 
        
         this.matricule = ++nb_vehicules;
     }
 
 
	 
	 public Vehicule(int annee,int  matricule,int puissance,double prix){
      
	
        this.matricule = ++nb_vehicules;
       this.annee = annee;
	   this.prix = prix;
       this.puissance = puissance;
      

      }
	 
	 //getters accesseurs
	 
	 
     public int getMatricule() {
		 
       return this.matricule;
} 

	public int getAnnee(){
	 
	   return this.annee ;
 }
 
   public double getPrix( ){
	 
	 return this.prix ;
 }
 
   public int getPuissance(){
	 
	 return this.puissance ;
 }
   public int getNb_vehicules(){
	 
	 return this.nb_vehicules ;
 }
 
 
 
 //setters modificateurs 
 
 public void setMatricule (int  matricule  ){
	 
	 this.matricule  = matricule ;
 }
 
   public void setAnnee(int annee){
	 
	 this.annee = annee ;
 }
 
   public void setPrix (double  prix){
	 
	this.prix  = prix  ;
 }
 
   public void setpuissance (int puissance ){
	 
	this.puissance  = puissance  ;
 }
	 	  
   public void setNb_vehicules ( int nb_vehicules){
	 
	this.nb_vehicules  = nb_vehicules  ;
 }
	

         abstract public void demarrer();
         abstract public  void accelerer();



	
	 @Override
	public String toString() {
		return   this.annee +   ", matricule= " + this.matricule 
				+ ",d'une puissance de " + this.puissance + " CV et au prix de " + this.prix + " euros a ete enregistree." ;
	}


	 
	 
	 
	 
	 
	 
	 
 }
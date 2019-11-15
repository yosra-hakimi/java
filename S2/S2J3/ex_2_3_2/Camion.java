
//la classe Camion hérite la classe Vehicule 
   public class Camion extends Vehicule {
	  
	   public Camion(){
		 //Ce mot clé appelle le constructeur de la classe mère (Vehicule)
		 super();
		 
	 }
	 
	 public Camion(int annee,int  matricule,int puissance,double prix){
		 super(annee, matricule, puissance, prix);
		 
	 }
	 
	 
	 
	 public void demarrer( ){
		  System.out.println("Le camion  de" + this.annee +   ", matricule=" + this.matricule +" demarre!");
		 
	 }
	 
	 
        public  void accelerer(){
			
			  System.out.println("Le camion de" + this.annee +   ", matricule=" + this.matricule + " accelere!");
			
				
			
		}
	  
	  
	  	 @Override
	public String toString() {
		return   "un Camion "+this.annee +   ", matricule= " + this.matricule 
				+ ",d'une puissance de " + this.puissance + " CV et au prix de " + this.prix + " euros a ete enregistree." ;
	}
	  
	 
	  
	  
	  
  }

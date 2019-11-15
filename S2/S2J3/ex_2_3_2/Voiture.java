


	 //la classe Voiture hérite la classe Vehicule 
	 public  class Voiture extends Vehicule { 
	 
	 
	 public Voiture(){
		 //Ce mot clé appelle le constructeur de la classe mère (Vehicule)
		 super();
		 
	 }
	 
	 public Voiture(int annee,int  matricule,int puissance,double prix){
		 super( annee, matricule, puissance, prix);
		 
	 }
	 
	 
	 
	 public void demarrer(){
		  
               		  
		  System.out.println("la voiture de " + this.annee +  ", matricule= " + this.matricule +" demarre!");
		 
		 
	 }
	 
	 
        public void accelerer(){
			
			  System.out.println( "la voiture de " + this.annee +   ", matricule= " + this.matricule +" accelere!"  ) ;
			
				

		}
		 @Override
	public String toString() {
		return   "une voiture "+this.annee +   ", matricule= " + this.matricule 
				+ ",d'une puissance de " + this.puissance + " CV et au prix de " + this.prix + " euros a ete enregistree." ;
	}
	 
	  
	 
	 
	 
 }
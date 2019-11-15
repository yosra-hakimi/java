public class Cabine{
	    private static int nId =0;


		private int longueur;
    private int largeur;
	private int nbre_c;
		public int id;
		
		
		//getters accesseurs
   public int getLongueur() {
     return this.longueur;
} 
  public int getLargeur(){
	 
	 return this.largeur ;
 }
   public int getId(){
	 
	 return this.id ;
 }
 
  public int getNbre_c(){
	 
	 return this.nbre_c ;
 }
 //setters modificateurs
 
 public void setLongueur(int longueur){
	 
	 this.longueur = longueur ;
 }
 
   public void setLargeur(String largeur){
	 
	 this.largeur = largeur ;
 }
 
   public void setId(int id){
	 
	this.id = id ;
 }
	
	   public void setNbre_c(int nbre){
	 
	    this.nbre_c = nbre ;
 }
 
 
 
	public Cabine (){
		
		 id = nId;
        nId++;

	//this.id =5;
		
	}
	public Cabine(int nbre){
		 this.id = nId;
        nId++;

		
		this.nbre_c = nbre ;
		
	}
	public int dimension (int longueur ,int largeur){
		
		return (this.longueur + this.largeur );
	}
	
	
	
public String toString() {
    return (" La cabine n "+ this.id );
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
public class Pont{
	    private static int nId =0;


	private String materiaux ;
	private int longueur;
	private int largeur ;
	public int id;
	private Mat m ;
	
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
 
 
 //setters modificateurs
 
 public void setLongueur(int longeur){
	 
	 this.longeur = longeur ;
 }
 
   public void setLargeur(String largeur){
	 
	 this.largeur = largeur ;
 }
 
   public void setId(int id){
	 
	this.id = id ;
 }
	
	public Pont(){
		 id = nId;
        nId++;

		//Sthis.id=3;
		
	}
	
	public Pont(String materiaux, Mat m){
		this.m=m;
		 this.id = nId;
        nId++;

		
		this.materiaux = materiaux;
		
	}
	public int dimension(int longueur,int largeur) {

   	return (this.longueur + this.largeur );

	}
	
public String toString() {
    return ("Le pont n "+ this.id+ " est constitue par "+this.m.toString());
}

	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
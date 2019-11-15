
public class Coque{
	    private static int nId =0;


	private String materiaux ;
	private String forme;
	private int longueur;
    private int largeur;
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
	
	public Coque(){
		 id = nId;
        nId++;

		//this.id=2;
	}
	
	public Coque(int longueur ,int largeur ){
		
		 this.id = nId;
        nId++;

		this.longueur = longueur ;
		this.largeur =largeur;
	}
	
	public int dimension (int longueur ,int largeur){
		
		return (this.longueur + this.largeur );
	}
	
	
// methode toString()

public String toString() {
    return (" La coque n "+ this.id );
}

	
}

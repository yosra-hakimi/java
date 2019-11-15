
public class Mat{
	    private static int nId =0;


	private String materiaux ;
	private String forme;
	private int longueur;
    private int largeur;
	public int id;
	 private Voile v;
	
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
	
	public Mat(){
		 id = nId;
        nId++;

		//this.id=6;
	}
	
	public Mat(int longueur ,int largeur , Voile v ){
		this.v = v;
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
    return ("Le Mat n "+ this.id+ " qui est constitue par "+this.v.toString() );
}

	
	
}

public class Coque{
	
	private String materiaux ;
	private String forme;
	private int longueur;
    private int largeur;
	public int id;
	
	
	public Coque(){
		this.id=2;
	}
	
	public Coque(int longueur ,int largeur ){
		this.longueur = longueur ;
		this.largeur =largeur;
	}
	
	public int dimension (int longueur ,int largeur){
		
		return (this.longueur + this.largeur );
	}
	
	
		public static void main(String[] args) {
	   
	 
}
	
}

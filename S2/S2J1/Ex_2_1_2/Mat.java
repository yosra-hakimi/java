
public class Mat{
	
	private String materiaux ;
	private String forme;
	private int longueur;
    private int largeur;
	public int id;
	
	
	public Mat(){
		this.id=6;
	}
	
	public Mat(int longueur ,int largeur ){
		this.longueur = longueur ;
		this.largeur =largeur;
	}
	
	public int dimension (int longueur ,int largeur){
		
		return (this.longueur + this.largeur );
	}
	
		public static void main(String[] args) {
	   
	 
}
	
	
}
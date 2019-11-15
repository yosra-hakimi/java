

public class Voile{
	
  private String matériaux;   
  private int largeur;
  public int longueur;
  protected String forme; 
  
  private boolean enroule ;
  private boolean deroule ;



	public  Voile(){
 
}
	
	
		public  Voile(int largeur ,int longueur){
 
        this.longueur = longueur ;
		this.largeur = largeur ;
 
}
	
	
	public  void enrouler(boolean enroule){
		
		 this.enroule = enroule;	
	}
	
	public void derouler( boolean deroule){
		
		 this.deroule = deroule;
		
		
	}
	
	
	
	public boolean amelioration1(boolean enroule){
		
		if (this.enroule==true) 
		return enrouler();
	else 
		return derouler();
		
			
	}
	
	
	public boolean amelioration2(boolean enroule){
		
		if (this.enroule)
			return this.enroule ;
		else 
			return (!(this.enroule)) ;
		
	}
	
	public static void main(String[] args) {
	   
	   Voile v = new voile();
	   
        v.amelioration2(true);
		
    }
	
	
}
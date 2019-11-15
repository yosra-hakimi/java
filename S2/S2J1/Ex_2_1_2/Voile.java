

public class Voile{
	
  private String materiaux;   
  private int largeur;
  public int longueur;
  protected String forme; 
  
  private boolean enroule ;
  private boolean deroule ;
  public int id ;



	public  Voile(){
     this.id= 4;
}
	
	
		public  Voile(int largeur ,int longueur){
 
        this.longueur = longueur ;
		this.largeur = largeur ;
 
}
	
	
	public  boolean enrouler(boolean enroule){
		
		
		 this.enroule = enroule;
        return enroule;		 
	}
	
	public boolean derouler( boolean deroule){
		
		 this.deroule = deroule;
		return deroule;
		
		
	}
	
	
	
	public boolean amelioration1(boolean enroule){
		
		if (this.enroule==true) 
		return enrouler(enroule);
	else 
		return derouler(enroule);
		
			
	}
	

	public static void main(String[] args) {
	   
	   Voile v = new Voile();
	   
       System.out.println( v.amelioration1(false) );
		
		
		
    }

	
	
}
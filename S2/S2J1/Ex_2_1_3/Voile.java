

public class Voile{
	    private static int nId =0;


  private String materiaux;   
  private int largeur;
  public int longueur;
  protected String forme; 
  
  private boolean enroule ;
  private boolean deroule ;
  public int id ;


//getters accesseurs
   public boolean getEnroule() {
     return this.enroule;
} 

  public boolean getDeroule() {
     return this.deroule;
} 

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
 
  public void setEnroule(boolean enroule){
	 
	 this.enroule = enroule ;
 }
  public void setDnroule(boolean deroule){
	 
	 this.deroule = deroule ;
 }
 
 
 public void setLongueur(int longeur){
	 
	 this.longeur = longeur ;
 }
 
   public void setLargeur(String largeur){
	 
	 this.largeur = largeur ;
 }
 
   public void setId(int id){
	 
	this.id = id ;
 }
	
	public  Voile(){
		 id = nId;
        nId++;

     //this.id= 4;
}
	
	
		public  Voile(int largeur ,int longueur){
			 this.id = nId;
        nId++;

 
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
	
	  public String toString() {
        return (" Le voile n "+ this.id);
    }

	

	public static void main(String[] args) {
	   
	   Voile v = new Voile();
	   
       System.out.println( v.amelioration1(false) );
		
		
		
    }

	
	
}
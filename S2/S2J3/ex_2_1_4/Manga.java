

public class Manga extends Livre {
	
	
	
	
	public Manga(String titre, String  auteur,double prix,int nbPages) {
     super( titre, auteur, prix, nbPages);

  }
  
  
  
    public void afficher() {
    System.out.print(toString());
  }
  
	 @Override
	 public String toString(){
		 return 
		 super.toString() ;
	 }
	 
	
		
	
	
}
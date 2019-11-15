import java.util.ArrayList;

public class LivreRecette extends Livre {
	
	
	public LivreRecette(String titre, String  auteur,double prix,int nbPages) {
     super( titre, auteur, prix, nbPages);

  }
  
  
  public void addRecette(Recette rc1){
	  
	  ArrayList<Recette> tabrecette = new ArrayList<Recette>();
       tabrecette.add(rc1);
   
    System.out.println(tabrecette);
	  
	  
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
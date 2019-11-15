
public class BD extends Livre {
	
	public boolean couleur ;
	
	
	public BD(String titre, String  auteur,double prix,int nbPages,boolean couleur) {
     super( titre, auteur, prix, nbPages);
	 this.couleur = couleur ;
	
  }
  
  // Accesseur
  public boolean getCouleur() {
    return this.couleur;
  }


// Modificateur
  public void setCouleur(boolean couleur) {
    this.couleur = couleur;
  }
  
  
    public void afficher() {
    System.out.print(toString());
  }
  
	 @Override
	 public String toString(){
		 return 
		 super.toString() +"couleur:" + this.couleur;
	 }
	 
	
		
	
	
}
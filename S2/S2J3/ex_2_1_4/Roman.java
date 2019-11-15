
public class Roman extends Livre {
	
	
	public int nbChapitre ;
	public String description ;
	
	public Roman(String titre, String  auteur,double prix,int nbPages) {
     super( titre, auteur, prix, nbPages);
   
  }
  
  //setters
  
    public void setNbChapitre(int n) {
    if (n > 0) {
      this.nbChapitre = n;
    }
    else {
      System.err.println("Erreur : nombre de pages négatif !");
    }
  }
  
  
  public void setDescription(String description) {
  
      this.description = description;
	  
    }
	
    //getters
	
  public int getNbChapitre() {
    return this.nbChapitre;
  }

  public String getDescription() {
    return this.description;
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
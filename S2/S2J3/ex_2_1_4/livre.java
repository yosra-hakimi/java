

 public class Livre {
	 
	  protected String titre, auteur;
	  protected double prix ;
      protected int nbPages;
  
    // Constructeurs
  public Livre(String titre, String  auteur,double prix,int nbPages) {
    this.auteur = auteur;
    this.titre = titre;
	this.prix = prix;
    this.nbPages = nbPages;
	
  }
  
   // Accesseur
  public String getAuteur() {
    return this.auteur;
  }

  public String getTitre() {
    return this.titre;
  }

  public int getNbPages() {
    return this.nbPages;
  }

  public double getPrix() {
    return this.prix;
  }

  // Modificateur
  public void setAuteur(String unAuteur) {
    this.auteur = unAuteur;
  }

  public void setTitre(String unTitre) {
    this.titre = unTitre;
  }
  public void setNbPages(int nbPages) {
    this.nbPages = nbPages;
  }
  public void setPrix(double prix) {
    this.prix = prix;
  }
	 
	  public void afficher() {
    System.out.print(toString());
  }
  

  
   @Override
  public String toString() {
    return
      "Livre [titre=" + this.titre + ",auteur=" + this.auteur + ",nbPages=" 
      + this.nbPages  + ",prix=" + this.prix + "] ";
  }


	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
 }
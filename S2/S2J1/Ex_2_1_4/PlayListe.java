
 public interface PlayListe{

	 // Accesseur
  public String getNom() ;
  public String getGenre() ;
  public int getNombreTitres() ;
public String gettabMusique() ;
  
  
  // Modificateur
  public void setNom(String nom) ;
  public void setGenre(String genre) ;
  public void setNombreTitres(int nombreTitres) ;
  public void settabMusique(String musique) ;
  
  public void afficher();
	
public void ajouter();
public void eliminer();

	
	 
	 
	 
	 
	 
	 
 }
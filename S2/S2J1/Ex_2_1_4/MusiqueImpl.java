
 public class MusiqueImpl implements Musique{
	
	public String titre, autheur, interprete, genre ;
	
	public MusiqueImpl(String titre, String autheur, String interprete, String genre ){
		
		this.titre=titre;
		this.autheur =autheur;
		this.interprete=interprete;
		this.genre=genre;
		
	}
	
	// Accesseur
  public String getTitre() {
	  this.titre = titre;
  }
  public String getAutheur() ;
  {
	  this.autheur = autheur;
  }
  public String getInterprete() {
	  this.interprete=interprete ;
  }
public String getGenre() {
	this.genre=genre;
}
  
  
  // Modificateur
  public void setTitre(String titre) {
	  return this.titre;
  }
  public void setAutheur(String autheur)  {
	  return this.autheur;
  }
  public void setInterprete(String interprete)  {
	  return this.interprete;
  }
  public void setGenre(String genre)  {
	  return this.genre;
  }
  
  public String afficher(){
      System.out.println("titre:"+ this.titre +"autheur:"+this.autheur + "interprete:"+this.interprete +"genre"+this.genre)
  }
  
  public boolean vérifier(){
	  
  }
	
	
	
	
	
	
	
	
	
	
	
}
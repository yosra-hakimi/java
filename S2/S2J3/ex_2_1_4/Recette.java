import java.util.ArrayList;
public class  Recette {
	
	public String nom ,description;
	
	public int niveau_dif ;
	
	
	//une liste d'étapes à réaliser
	
	

  
  public Recette (String nom,String description,int niveau_dif){
	  this.nom= nom;
	  this.description =description;
	  this.niveau_dif=niveau_dif;
	  
	 
	  
  }
    public void addAstuce(String a){
	  
	 ArrayList<String> astuce = new ArrayList<String>();
       astuce.add(a);
   
    System.out.println(astuce);
  	  
  }
  
    public void addEtape(String e){
	  
	 ArrayList<String> etape = new ArrayList<String>();
       etape.add(e);
   
    System.out.println(etape);
  	  
  }
  
  
    public void afficher() {
    System.out.print(toString());
  }
  
	   @Override
  public String toString() {
    return
      "Recette [Nom=" + this.nom + ",description=" + this.description+ ",niveau_dif=" 
      + this.niveau_dif  +"] ";
  }

	
		
	
	
}
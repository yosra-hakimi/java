
public class Bateau {
	
private int vie;
private String nom ;
public int id ;
public int longueur;
 public int largeur;

public Bateau() {
this.nom = "Pirate" ;
this.id=1;
}
public Bateau(int longueur) {
this.vie = longueur;
}

public int getVie() {
return this.vie;
}

public boolean estCoule() {
return this.vie <= 0;
}

public void touche() {
this.vie = this.vie - 1;


	
}

public int dimension (int longueur ,int largeur){
		
	return (this.longueur + this.largeur );
	}

}

		
	

	
	
	

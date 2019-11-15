public class Main{
	

	
		public static void main(String[] args) {
			
			
	    Livre l1 = new Livre("Le petit prince","St Exupéry",10.40, 50) ;
        Livre l2 = new Livre("Contes","Grimm",14.40,254) ;
		l1.afficher() ;
        l2.afficher();
		
		
	    BD b1 = new BD("Lucky Luke","Morris",10.40, 45, true);
        BD b2 = new BD("Tintin","Herge",200.40, 45, false) ;
        b1.afficher() ;
        b2.afficher() ;




        Manga m1 = new Manga("One piece","Eiichiro Oda",5.40, 62);
        Manga m2 = new Manga("Death Note","Tsugumi Oba",7.40, 75) ;
        m1.afficher() ;
        m2.afficher() ;
		
		Roman r1 = new Roman("Dora","Dora", 3.5,300) ;
        r1.afficher() ;

        r1.setNbChapitre(12);
		r1.setDescription("Une description quelconque");
		
		
		System.out.println(r1.getNbChapitre());
		System.out.println(r1.getDescription());
		
		
		 LivreRecette lrc1 = new LivreRecette("Marmiton", "Philippe Etchebest", 15.98, 110);
		  lrc1.afficher() ;
		  
		  Recette rc1 = new Recette("Les pâtes crues", "Comment réaliser de délicieuses pâtes crues.", 3);
		  rc1.afficher() ;
		  rc1.addAstuce("Ne pas les faire cuire.");
		  rc1.addEtape("Sortir les pâtes de leur emballage");

          lrc1.addRecette(rc1);


		}
}
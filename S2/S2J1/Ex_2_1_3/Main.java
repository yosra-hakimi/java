
   public class Main{
	

	
		public static void main(String[] args) {
	    Bateau pinta = new Bateau(10);
       Bateau santaMaria = new Bateau(4);
	   
	   System.out.println( pinta.getVie() );
	   System.out.println( santaMaria.getVie() );
	 
	   pinta.setNom("theBig");
	   System.out.println( pinta.getNom() );
	 System.out.println(pinta.toString());
}
	
	
}
import java.util.Arrays;
class rechercher {
	
  public static int search(int[] tab ,int x ) {
    int  lg=tab.length ;
    if ( lg == 0)
		return 0;
			
    if (tab[lg-1] == x) 
        return 1;	
	
    return search(Arrays.copyOf(tab,lg-1), x); // Arrays.copyOf(tab,lg-1) :copier le tableau a partir l'indice =longueur_tableau-1
		

  }


    public static void main(String[] args) {
                int tableau[] = {6,20,12,1000,8} ;
				
				if (search(tableau,12) == 0) {
					System.out.println("false");
				}
				else if (search(tableau,12) == 1){
				   System.out.println("true");
				}
				if (search(tableau,30) == 0) {
					System.out.println("false");
				}
				else if (search(tableau,30) == 1){
				   System.out.println("true");
				}
				
		}
		
	
	
/*
		
		public static int search(int x, int[] tab ,int a ) {
			
			if (a >= tab.length)
				return 0;
			if (tab[a] == x)    
				return 1; 
			return search(x, tab ,a+1); 
		
		}
		
		



        public static void main(String[] args) {
                int tableau[] = {6,20,12,1000,8} ;
				
				if (search(12, tableau,0) == 0) {
					System.out.println("false");
				}
				else if (search(12, tableau,0) == 1){
				   System.out.println("true");
				}
				
		}
		*/
				
				
				
				
				
				
				
				
				
				
								
				
	

		
}


 
	

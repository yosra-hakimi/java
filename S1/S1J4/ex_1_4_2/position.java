import java.util.Arrays;
class position {
	

		
		 public static int  SearchPos (int tab[], int x)  {
			  
			int lg= tab.length -1;
			  if (lg <= 0  ) 
				  return 0;
			  
			  if (tab[lg] == x ) 
				  return lg;
			  
			  if (tab[lg] < x ) 
				  return lg+1;
			  
			
			 
			  else
			  {
                 return (SearchPos(Arrays.copyOf(tab,lg-1),x ) ); 
			  }
			
			 
		 }
		
		

		
	


    public static void main(String[] args) {
                int tableau[] = {0,2,4,6,7,8} ;
			
				System.out.println(SearchPos (tableau, 2) );
				System.out.println(SearchPos (tableau, 10) );
				System.out.println(SearchPos (tableau, -5) );
		
				
			
				
		}
}
		
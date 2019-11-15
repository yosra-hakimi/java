
import java.util.Scanner;
public class sapinbeau {
	
public static void printTriangle (int nombredeligne)
{
	
	
	//int nombredeligne = 3;
 
for (int k = 0; k <= nombredeligne; k++)
{
	
	for (int j = 0; j < (nombredeligne-k); j++)
		System.out.print(" ");
	for (int i = 0; i < (k*2+1); i++)
		System.out.print("*");
	    System.out.println("");
}	

}


public static void printRectangle (int size)
{
	
//int size = 3;

        for (int i=0; i <size ; i++)
				
        {
			for (int k=0; k <((size+1)/2) ; k++)
             System.out.print(" ");
			 
            for(int j=0; j< size-1 ; j++)
            {
                System.out.print("*");
            }
			
             System.out.println("*");
        }
	
			
		
    }



public static void printMulTriangle (int s)
    {
		 
 if (s < 1) return ;
 
							 
	  printMulTriangle (s-1);
	
	  printTriangle (s) ;
	  
	  	 

	}
	
	

public static void printSapin(int s)
    {	   
	  printMulTriangle (s) ;

	  printRectangle (s);
	
		
	}

 public static void main(String[] args) {
	   Scanner sc = new Scanner(System.in);
		System.out.println("Vous voulez un Sapin e de combien de triangle?");
		int nombredetriangle=sc.nextInt();
	 
        printSapin(nombredetriangle);
		
    }


}		
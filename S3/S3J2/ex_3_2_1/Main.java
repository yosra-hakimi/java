package ex_3_2_1;

import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);


	public static void main(String[] args) throws Exception{
		 MyException m = new MyException();
			
			System.out.println("Saisir un nombre entre 10 et 30 inclus: ");	
			 int x = sc.nextInt();	
			 
			 m.UseMyException(x);
			 //m.fun(x);
 
}


	
}

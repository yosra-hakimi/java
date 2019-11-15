package ex_3_2_5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class SautoLit {

 static void lecture(Scanner source) {
     while(source.hasNextLine()) {
         String s = source.nextLine();
         System.out.println( s);

     }
 }

 static public void main(String[] args)throws IOException, FileNotFoundException {
	 
	    File file = new File("C:/Users/yhakimi/eclipse-workspace/ex_3_2_5/src/ex_3_2_5/yosra.txt");
	    Scanner sc = null;
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
	 lecture(sc);
	 
	 
 }
}

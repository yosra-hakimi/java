package ex_3_2_2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MaximumWithoutExceptions {
	    private static BufferedReader br;
	    private static String line;
	    private static int n ; 

		public static void main (String args[]) throws IOException {
			
			try {
				 br = new BufferedReader(new FileReader("data.txt"));
					}
		/*
			 catch (IOException e) 
			    {
			        //Alternate logic
			        e.printStackTrace();
			    }*/
		    catch (FileNotFoundException e) 
		    {
		        //Alternate logic
		        e.printStackTrace();
		    }
			
	        // could generate FileNotFoundException (checked)
	       
	        int max = -1;
	       
	        try { 
	        	 line = br.readLine();
	        	}catch (IOException e) {
	        		e.printStackTrace();
	        	}
	      
			// peut générer IOException
	       try {
	    	   while (line != null) 
	           n = Integer.parseInt(line);
	            } catch(NumberFormatException e){
	            	e.printStackTrace();
	            }
	       
	        
	            // peut générer NumberFormatException
	            
	            try{
	            	if (n > max) max = n;
	            	line = br.readLine();
	             }catch (IOException e) {
			        e.printStackTrace();
			    }
	            // peut générer IOException
	       
	        System.out.println("Maximum = " + max);
	    }
	}
	    



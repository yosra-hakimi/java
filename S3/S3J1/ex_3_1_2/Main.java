package ex_3_1_2;

import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) {
		
		Map<String, Integer> numberMapping = new HashMap<String, Integer>();
		 numberMapping.put("one",1);
		 numberMapping.put("four",4);
		 numberMapping.put("two",2);
		 numberMapping.put("three",3);
		  
	   System.out.println(numberMapping); 
	   
	   Map<String, String> chaineMapping = new HashMap<String, String>();
	  // System.out.println(chaineMapping.isEmpty());
	   chaineMapping.put("Steve", "London");
	   chaineMapping.put("John", "New York");
	   chaineMapping.put(" Rajeev", "Bengaluru");
	   System.out.println(chaineMapping); 
	   System.out.println(chaineMapping.isEmpty());
	   System.out.println( chaineMapping.size() );
	   System.out.println(chaineMapping.containsKey( "Steve"));
	   System.out.println(chaineMapping.containsKey( "New York"));
	   System.out.println(chaineMapping.containsValue("New York"));
	   System.out.println(chaineMapping.get("Steve")); 
	   chaineMapping.put(" Rajeev", "Tunisie");
	   System.out.println(chaineMapping);
	   
	   chaineMapping.remove("Steve");
	   System.out.println(chaineMapping);
	   
	   chaineMapping.remove("John", "New York");
	   System.out.println(chaineMapping);

	   
	   
	}
}

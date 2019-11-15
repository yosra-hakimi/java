package com.thp.spring.simplecontext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class AppXMLMain {

	public static void main(String[] args) {
	       ApplicationContext vApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	       
	 
	       Moussaillon m = (Moussaillon)vApplicationContext.getBean("moussaillon",Moussaillon.class);
	       m.afficher();
	
	}

}

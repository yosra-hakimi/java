package com.thp.spring.simplecontext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppJavaConfigMain {

	public static void main(String[] args) {
	
		   ApplicationContext vApplicationContext = new AnnotationConfigApplicationContext(AppMoussaillonConfig.class);
    
			 
	       Moussaillon m = (Moussaillon)vApplicationContext.getBean("moussaillon",Moussaillon.class);
	       m.afficher();

	}

}

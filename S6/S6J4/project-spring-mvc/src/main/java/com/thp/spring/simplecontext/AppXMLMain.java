package com.thp.spring.simplecontext;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.thp.springmvc.dao.BateauDAO;
import com.thp.springmvc.dao.MoussaillonDAO;
import com.thp.springmvc.entity.Bateau;
import com.thp.springmvc.entity.Moussaillon;
public class AppXMLMain {

	public static void main(String[] args) {
	  
	       
	     ApplicationContext ContextBateau = new ClassPathXmlApplicationContext("applicationContext.xml");
	       
	      BateauDAO bateauDao = (BateauDAO) ContextBateau.getBean("bateaudao");
	       //bateauDao.create(18, "Black Pearl", "Navire de Guerre",150);
	       //bateauDao.create(2, "Black Pearl", "Navire de Guerre", 150);
	      // bateauDao.create(3, "Black Pearl", "Navire de Guerre", 20);
	      // bateauDao.create(4, "Black Pearl", "Navire de Guerre", 1);
	       //bateauDao.toString();
		//bateauDao.create(4, "White Pearl", "Navire ", 8);
	       
	 
	     // Bateau bateauFound = bateauDao.findById(2);
	       Bateau bateauFound = bateauDao.findById(20);

	       System.out.print(bateauFound + "\n");
	    
	      
	       
	      // List<Bateau> bateauFoundAll = (List<Bateau>) bateauDao.findAll();
	       
	      // System.out.print(bateauFoundAll + "\n");
	   
	       ApplicationContext ContextMoussaillon = new ClassPathXmlApplicationContext("applicationContext.xml");
	         
	      
	       MoussaillonDAO moussaillondao  = (MoussaillonDAO) ContextMoussaillon.getBean("moussaillonda");
	       
	       
	       //moussaillondao.create(4, "yosra","hakimi", "ing", 2) ;
	       //moussaillondao.create(1, "chiheb","hakimi", "dev", 2) ;
	      // moussaillondao.create(3, "dali","hakimi", "aff", 20) ;
	      // moussaillondao.create(9, "yosr", "hkimi", "ingdev", 2);
	       
	    Moussaillon moussaillonFound = moussaillondao.findById(2);

	      System.out.print( moussaillonFound+ "\n");
	       
	   // List<Moussaillon> moussaillonFoundAll = (List<Moussaillon>) moussaillondao.findAll();
	       
		   //  System.out.print(moussaillonFoundAll + "\n");
	      
	       
	   
	}

}

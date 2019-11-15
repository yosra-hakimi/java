package com.thp.spring.simplecontext;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.thp.project.vintud.dao.DaoAnnounce;
import com.thp.project.vintud.dao.DaoUser;
import com.thp.project.vintud.entity.impl.SearchImpl;


public class AppXMLMain {

	public static void main(String[] args) {
		
		//ApplicationContext ContextUser = new ClassPathXmlApplicationContext("applicationContext.xml");

		//DaoUser	 userDao  =  (DaoUser) ContextUser.getBean("userdao");
		//userDao.createAccount("yosra", "hakimi", "sassou", "yosra.hakimi@talan.com","azerty" ,"21049207","5 rue Damas denden ",1);
		
		//System.out.println(userDao.getUserByMail("george@Cara.com"));
		
		/*
		ApplicationContext ContextAnnouncement = new ClassPathXmlApplicationContext("applicationContext.xml");
		DaoAnnounce announceDao = (DaoAnnounce) ContextAnnouncement.getBean("annoncedao");
		final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.util.Date today = new java.util.Date();
		String date =  dateFormat.format(today.getTime());
		
		announceDao.addElement("phone","telephone neuf",3,8,"picture",date,true,50,"manar",6);
		
*/

		//ApplicationContext ContextAnnouncement = new ClassPathXmlApplicationContext("applicationContext.xml");
		//DaoAnnounce announceDao = (DaoAnnounce) ContextAnnouncement.getBean("annoncedao");
		//System.out.println(announceDao.getElement(1).toString());
		
		//System.out.println(announceDao.searchAnnouncementTitle("Veste Guoss comme nueve"));
		//System.out.println(announceDao.searchAnnouncementCategory(3));
	  
		//System.out.println(announceDao.searchAnnouncementPrice(24.98));
		//announceDao.updateAnnouncement("t-shirt adidas" , 1);
		//announceDao.deleteAnnouncement(1);
		
		
		
		
	       /*
	       ApplicationContext ContextSearch = new ClassPathXmlApplicationContext("applicationContext.xml");
	       
	       DaoSearch  searchdao = (DaoSearch) ContextSearch.getBean("searchdao") ;
	       
	       SearchImpl search = new SearchImpl("","");
	      searchdao.addElement(search);
	      */
	  
	       

	       
	 
	      
	       
	   
	}

}

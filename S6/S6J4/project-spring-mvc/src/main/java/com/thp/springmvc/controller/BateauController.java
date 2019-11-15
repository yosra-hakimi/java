package com.thp.springmvc.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.thp.springmvc.dao.BateauDAO;
import com.thp.springmvc.entity.Bateau;

@Controller
public class BateauController {

	
	 @Autowired
	    private BateauDAO bateaudao;
	  
	  @RequestMapping(value="/bateau", method = RequestMethod.GET)
	   public String getAllBateau(ModelMap model){
		  
	        Collection<Bateau>  bateau = bateaudao.findAll();

	       model.addAttribute("bateau", bateau);

	       return "bateau";
	   }
	  
	  
	  
	  @RequestMapping(value="/addBateau", method = RequestMethod.GET)
	    public String addBateauForm()
	    {   
	        return "addBateau";
	    }
	   
	  
	
	    @RequestMapping(value="/addBateau", method = RequestMethod.POST)
	    public String formulaire(@RequestParam("id") int id, @RequestParam("name") String name, @RequestParam("type") String type, @RequestParam("size") double taille)
	    {	
	    	int bateau =bateaudao.create(id, name, type, taille);
	        
	        return "addBateau";
	    }
	    
	   
	    @RequestMapping(value = "/bateau/{id}", method = RequestMethod.GET)
	    public String GetBateauById(@PathVariable int id,ModelMap model) {
	    
	        
	        
	           Bateau bateau = bateaudao.findById(id);
	           
	           model.addAttribute("bateau", bateau);

		       return "bateauid"; 

	  
	    }
	  

  
	  
}

package com.thp.springmvc.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.thp.springmvc.dao.MoussaillonDAO;
import com.thp.springmvc.entity.Bateau;
import com.thp.springmvc.entity.Moussaillon;

@Controller
public class MoussaillonController {

	  @Autowired
	    private MoussaillonDAO moussaillondao;
	  
	  @RequestMapping(value="/moussaillons", method = RequestMethod.GET)
	   public String getAllMoussaillon(ModelMap model){
		  
	        Collection<Moussaillon>  moussaillons = moussaillondao.findAll();

	       model.addAttribute("moussaillons", moussaillons);

	       return "moussaillons";
	   }
	  
	  
	  
	  @RequestMapping(value="/formulaire", method = RequestMethod.GET)
	    public String addMoussaillonForm()
	    {   
	        return "formulaire";
	    }
	   
	  
	
	    @RequestMapping(value="/formulaire", method = RequestMethod.POST)
	    public String formulaire(@RequestParam("id") int id, @RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("config") String config, @RequestParam("bateau_id") int bateau_id)
	    {	
	    	int moussaillon = moussaillondao.create(id, firstName, lastName, config, bateau_id);
	        
	        return "formulaire";
	    }
	    
	   
	    @RequestMapping(value = "/moussaillons/{id}", method = RequestMethod.GET)
	    public String GetBateauById(@PathVariable int id,ModelMap model) {
	     
	        
	        
	           Moussaillon moussaillons = moussaillondao.findById(id);
	           
	           model.addAttribute("moussaillons", moussaillons);

		       return "moussaillonid"; 

	     
	    }
	  
	  

}



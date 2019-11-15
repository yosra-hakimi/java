package com.thp.simplecontext.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.thp.simplecontext.dao.MoussaillonDAO;
import com.thp.simplecontext.entity.Moussaillon;
import com.thp.simplecontext.service.MoussaillonService;

@RestController
public class MoussaillonController {
	
	 @Autowired
	private MoussaillonService moussaillonservice ;

	  
	  
	  @GetMapping(path ="/moussaillon/{moussaillonId}", produces = MediaType.APPLICATION_JSON_VALUE)
	   public @ResponseBody Moussaillon getMoussaillonByIdRest(@PathVariable("moussaillonId") int moussaillonId){
	       return moussaillonservice.findById(moussaillonId);
	       	  
	  }
	  
	  
	  @PostMapping("/moussaillon/add")
	  public @ResponseBody int createMoussaillon (@RequestBody Moussaillon moussaillon){
	    return moussaillonservice.createMoussaillon(moussaillon);

	  }
	  
		@DeleteMapping(path = "/moussaillon/remove/{id}")
		public String delete(@PathVariable("id") int id) {

			 moussaillonservice.delete(id);
			 
			 return "le moussaillon "+ id +"a été supprimé avec succès";
			
		}

	  
	  
	     
}



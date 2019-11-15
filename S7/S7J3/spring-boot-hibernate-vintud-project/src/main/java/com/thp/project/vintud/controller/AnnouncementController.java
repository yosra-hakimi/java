package com.thp.project.vintud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thp.project.vintud.entity.impl.AnnouncementImpl;
import com.thp.project.vintud.service.AnnouncementService;


@Controller
public class AnnouncementController {

	@Autowired
	private AnnouncementService announcementService  ;
	
	  @GetMapping(path ="/announce/{announceId}", produces = MediaType.APPLICATION_JSON_VALUE)
	   public @ResponseBody AnnouncementImpl getAnnounceByIdRest(@PathVariable("announceId") int announceId){
	       return announcementService.getElement(announceId);
	       	  
	  }
	
}

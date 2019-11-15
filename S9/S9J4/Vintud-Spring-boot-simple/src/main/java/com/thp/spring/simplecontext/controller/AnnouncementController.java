package com.thp.spring.simplecontext.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thp.spring.simplecontext.entity.impl.AnnouncementImpl;
import com.thp.spring.simplecontext.entity.impl.UserImpl;
import com.thp.spring.simplecontext.service.AnnouncementService;

@CrossOrigin()
@Controller
public class AnnouncementController {
	
	
	@Autowired
	private AnnouncementService announcementService;
    
    
    @GetMapping(path ="/announcements", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<AnnouncementImpl> findAllAnnouncements(){
    	return announcementService.findAllAnnouncements();
    }
    
   @GetMapping(path ="/announcement/{announcementId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Optional<AnnouncementImpl> findAnnouncementById(@PathVariable("announcementId") int announcementId){
    	return announcementService.findAnnouncementById(announcementId);
    }
   
   @GetMapping(path ="/announcements/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
   public @ResponseBody List<AnnouncementImpl> findAnnouncementByUserId(@PathVariable("userId") int userId){
   	return announcementService.findByUserId(userId);
   }
   
   @PostMapping(path="/announcement/add", produces = MediaType.APPLICATION_JSON_VALUE)
   public @ResponseBody HashMap<String, String> createAnnouncement (@RequestBody AnnouncementImpl announcementImpl){
	   
	    return announcementService.AddAnnouncement(announcementImpl);
   }

   @PutMapping("/announcement/update/{announcementId}")
   public @ResponseBody AnnouncementImpl updateAnnouncement(@RequestBody AnnouncementImpl announcementImpl, @PathVariable int announcementId) {

	   return announcementService.updateAnnouncement(announcementImpl, announcementId);
   }
   
   @DeleteMapping("/announcement/delete/{announcementId}")
   @ResponseBody HashMap<String, String> deleteAnnouncement(@PathVariable int announcementId) {
     return announcementService.deleteAnnouncement(announcementId);
   }
   
   @GetMapping(path ="/announcement/{announcementId}/user", produces = MediaType.APPLICATION_JSON_VALUE)
   public @ResponseBody List<UserImpl> findVendorInfos(@PathVariable("announcementId") int announcementId){
	   
   	return announcementService.ViewInfosVendor(announcementId);
   }
   
   @GetMapping(path ="/announcements/title/{title}", produces = MediaType.APPLICATION_JSON_VALUE)
   public @ResponseBody List<AnnouncementImpl> findByTitle(@PathVariable("title") String title){
	   
   	return announcementService.searchAnnouncementTitle(title);
   }
   
   @GetMapping(path ="/announcements/category/{categoryName}", produces = MediaType.APPLICATION_JSON_VALUE)
   public @ResponseBody List<AnnouncementImpl> findByCategory(@PathVariable("categoryName") String categoryName){
	   
   	return announcementService.searchAnnouncementTitle(categoryName);
   }
   
   @GetMapping(path ="/announcements/price/{price}", produces = MediaType.APPLICATION_JSON_VALUE)
   public @ResponseBody List<AnnouncementImpl> findByPrice(@PathVariable("price") Double price){
	   
   	return announcementService.searchAnnouncementPrice(price);
   }
   
   @GetMapping(path ="/announcements/ordredyprice", produces = MediaType.APPLICATION_JSON_VALUE)
   public @ResponseBody List<AnnouncementImpl> findAllAnnouncementsOrderedByPrice(){
   	return announcementService.filtreAnnouncementPrice();
   }

   @GetMapping(path ="/announcements/location", produces = MediaType.APPLICATION_JSON_VALUE)
   public @ResponseBody List<AnnouncementImpl> findAllAnnouncementsOrderedByLocation(){
   	return announcementService.filtreAnnouncementLocation();
   }
   
   @GetMapping(path ="/announcements/count", produces = MediaType.APPLICATION_JSON_VALUE)
   public @ResponseBody int countAnnouncements(){
   	return announcementService.viewNumberAnnouncement();
   }
    
}

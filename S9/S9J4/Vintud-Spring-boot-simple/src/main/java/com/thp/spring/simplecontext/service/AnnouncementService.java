package com.thp.spring.simplecontext.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import com.thp.spring.simplecontext.entity.impl.AnnouncementImpl;
import com.thp.spring.simplecontext.entity.impl.UserImpl;

public interface AnnouncementService {
	
	public List< AnnouncementImpl> findAllAnnouncements();
	
	public List< AnnouncementImpl> findByUserId(int connectedUserId);
	
	public Optional<AnnouncementImpl> findAnnouncementById(int announcementId);
	
	public HashMap<String, String> AddAnnouncement(AnnouncementImpl announcement);
	
	public HashMap<String, String> deleteAnnouncement(int id);
	
	public AnnouncementImpl updateAnnouncement(AnnouncementImpl announcement, int announcementId);
	
	public List<UserImpl> ViewInfosVendor(int id);
	
	public List< AnnouncementImpl> searchAnnouncementTitle(String title);
	
	public List< AnnouncementImpl> searchAnnouncementCategory(String category);
	
	public List< AnnouncementImpl> searchAnnouncementPrice(Double price);
	
	public List< AnnouncementImpl> filtreAnnouncementPrice();
	
	public List< AnnouncementImpl> filtreAnnouncementLocation();
	
	public int viewNumberAnnouncement();

}

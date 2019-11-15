package com.thp.spring.simplecontext.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.thp.spring.simplecontext.Repository.AnnouncementRepository;
import com.thp.spring.simplecontext.entity.impl.AnnouncementImpl;
import com.thp.spring.simplecontext.entity.impl.UserImpl;
import com.thp.spring.simplecontext.service.AnnouncementService;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class AnnouncementServiceImpl implements AnnouncementService{

	@Autowired AnnouncementRepository announcementRepository; 
	
	@Override
	public List<AnnouncementImpl> findAllAnnouncements() {
		return announcementRepository.findAll();
	}

	@Override
	public List<AnnouncementImpl> findByUserId(int connectedUserId) {
		return announcementRepository.findByUserId(connectedUserId);
	}

	@Override
	public Optional<AnnouncementImpl> findAnnouncementById(int announcementId) {
		return announcementRepository.findById(announcementId); 
	}

	@Override
	public HashMap<String, String> AddAnnouncement(AnnouncementImpl announcement) {
		HashMap<String, String> response = new HashMap<>(); 
		announcementRepository.save(announcement);
		response.put("message", "Announcement successfully Added");
		return response; 
	}

	@Override
	public HashMap<String, String> deleteAnnouncement(int id) {
		HashMap<String, String> response = new HashMap<>(); 
		announcementRepository.deleteById(id);
		response.put("message", "Announcement successfully Deleted");
		return response;
	}

	@Override
	public AnnouncementImpl updateAnnouncement(AnnouncementImpl announcement, int announcementId) {
		return announcementRepository.findById(announcementId)
				.map(a -> 
				{
					a.setTitle(announcement.getTitle());
					a.setDescription(announcement.getDescription());
					a.setCategory(announcement.getCategory());
					a.setPrice(announcement.getPrice());
					a.setPhoto(announcement.getPhoto());
					a.setDatePub(announcement.getDatePub());
					a.setStatus(announcement.isStatus());
					a.setNbrViews(announcement.getNbrViews());
					a.setLocation(announcement.getLocation());
					a.setUser(announcement.getUser());
					a.setPhoto(announcement.getPhoto());
					return announcementRepository.save(a);})
					.orElseGet(() -> {
				        announcement.setId(announcementId);
				        return announcementRepository.save(announcement);
				      });
	}

	@Override
	public List<UserImpl> ViewInfosVendor(int announcementId) {
		return null; // To be Implemented
	}

	@Override
	public List<AnnouncementImpl> searchAnnouncementTitle(String title) {
		return announcementRepository.findByTitle(title);
	}

	@Override
	public List<AnnouncementImpl> searchAnnouncementCategory(String category) {
		return announcementRepository.findByCategory(category);
	}

	@Override
	public List<AnnouncementImpl> searchAnnouncementPrice(Double price) {
		return announcementRepository.findByPrice(price);
	}

	@Override
	public List<AnnouncementImpl> filtreAnnouncementPrice() {
		return announcementRepository.findOrderedByPrice();
	}

	@Override
	public List<AnnouncementImpl> filtreAnnouncementLocation() {
		return announcementRepository.findByLocation();
	}

	@Override
	public int viewNumberAnnouncement() {
		return announcementRepository.countAnnouncements();
	}

}

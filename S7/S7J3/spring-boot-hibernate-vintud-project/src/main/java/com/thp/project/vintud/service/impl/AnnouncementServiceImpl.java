package com.thp.project.vintud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.thp.project.vintud.dao.DaoUser;
import com.thp.project.vintud.dao.impl.DaoAnnouncement;
import com.thp.project.vintud.entity.impl.AnnouncementImpl;
import com.thp.project.vintud.service.AnnouncementService;

@Transactional(propagation = Propagation.REQUIRES_NEW)
@Service
public class AnnouncementServiceImpl implements AnnouncementService {
	
	 @Autowired
	    private DaoAnnouncement daoAnnouncement;
	@Override
	public int addElement(String title, String description, int category_id, float price, String picture, String date,
			boolean is_available, int view_number, String localisation, int user_id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public AnnouncementImpl getElement(int id) {
		
		return daoAnnouncement.getElement(id);
	}

	@Override
	public boolean updateElement(int id, String caseToUpdate, Object newValue) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteElement(AnnouncementImpl element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<AnnouncementImpl> searchAnnouncementTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteAnnouncement(long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<AnnouncementImpl> searchAnnouncementCategory(int category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AnnouncementImpl> searchAnnouncementPrice(Double price) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateAnnouncement(String title, long id) {
		// TODO Auto-generated method stub
		return 0;
	}

}

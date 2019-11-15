package com.thp.project.vintud.service;

import java.util.List;

import com.thp.project.vintud.entity.impl.AnnouncementImpl;

public interface AnnouncementService {
	
	//public abstract boolean addElement(AnnouncementImpl element);
	public int addElement(String title,String description,int category_id,float price,String picture,String date,boolean is_available,int view_number,String localisation,int user_id) ;


	public abstract AnnouncementImpl getElement(int id);

	public abstract boolean updateElement(int id,String caseToUpdate,Object newValue);

	public abstract boolean deleteElement(AnnouncementImpl element);
	
	public List<AnnouncementImpl> searchAnnouncementTitle(String title) ;

	public int deleteAnnouncement(long id) ;
	
	public List<AnnouncementImpl> searchAnnouncementCategory(int category) ;
	
	public List<AnnouncementImpl> searchAnnouncementPrice(Double price) ;
	
	public int updateAnnouncement(String title, long id) ;

}

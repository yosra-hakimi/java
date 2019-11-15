package com.thp.spring.simplecontext.entity;

import com.thp.spring.simplecontext.entity.impl.AnnouncementImpl;
import com.thp.spring.simplecontext.entity.impl.UserImpl;

public interface Favoris {
	
	public  String getDateFavoris();

	public void setDateFavoris(String dateFavoris);

	public AnnouncementImpl getAnnouncement();

	public void setAnnouncement(AnnouncementImpl announcement);

	public UserImpl getUser();

	public void setUser(UserImpl user);

	public int getId();
	
	public void setId(int id);

}

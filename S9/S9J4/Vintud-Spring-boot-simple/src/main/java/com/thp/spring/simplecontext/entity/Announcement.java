package com.thp.spring.simplecontext.entity;

import com.thp.spring.simplecontext.entity.impl.CategoryImpl;
import com.thp.spring.simplecontext.entity.impl.UserImpl;

public interface Announcement {
	
	public int getId();

	public void setId(int id);

	public String getTitle();

	public void setTitle(String title);

	public String getDescription();

	public void setDescription(String description);

	public double getPrice();

	public void setPrice(double price);

	public byte[] getPhoto();

	public void setPhoto(byte[] photo);

	public String getDatePub();

	public void setDatePub(String datePub);

	public boolean isStatus();

	public void setStatus(boolean status) ;

	public int getNbrViews();

	public void setNbrViews(int nbrViews);

	public String getLocation();

	public void setLocation(String location);

	public CategoryImpl getCategory();

	public void setCategory(CategoryImpl category);

	public UserImpl getUser();

	public void setUser(UserImpl userId);
	
	public String toString();

}

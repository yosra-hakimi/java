package com.thp.project.vintud.entity;


import java.sql.Date;

public interface Announcement {

	public int getId();

	public void setId(int id);

	public String getTitle();

	public void setTitle(String title);

	public String getDescription();

	public void setDescription(String description);

	public int getCategoryId();

	public void setCategoryId(int categoryId);

	public float getPrice();

	public void setPrice(float price);

	public String getPicture();

	public void setPicture(String picture);

	public String getPublicationDate();

	public void setPublicationDate(String publicationDate);

	public boolean isAvailable();

	public void setIsAvailable(boolean isAvailable);

	public int getViewNumber();

	public void setViewNumber(int viewNumber);

	public String getLocalisation();

	public void setLocalisation(String localisation);

	public int getUserId();

	public void setUserId(int userId);

}

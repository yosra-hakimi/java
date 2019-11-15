package com.thp.project.vintud.entity.impl;


import java.sql.Date;

import com.thp.project.vintud.entity.Announcement;

public class AnnouncementImpl implements Announcement{

	private int id;
	private String title;
	private String description;
	private int categoryId;
	private float price;

	private int picture;

	private String publicationDate;
	private boolean isAvailable;
	private int viewNumber;
	private String localisation;
	private int userId;

	public AnnouncementImpl() {

	}

	public AnnouncementImpl(String title, String description, int categoryId, float price, int picture,
			String publicationDate, boolean isAvailable, int viewNumber, String localisation, int userId) {

		this.title = title;
		this.description = description;
		this.categoryId = categoryId;
		this.price = price;
		this.picture = picture;
		this.publicationDate = publicationDate;
		this.isAvailable = isAvailable;
		this.viewNumber = viewNumber;
		this.localisation = localisation;
		this.userId = userId;
	}



	public boolean equals(int id) {

		return this.id == id;

	}

//methode toString

	public String toString() {
		return "l'annonce dont l'identifiant " + id + " a un titre : " + title + " , et une description : "
				+ description + " , dont son prix est égale à : " + price;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public void setPicture(int picture) {

		this.picture = picture;
	}

	public int getPicture() {

		return picture;
	}

	public String getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(String publicationDate) {
		this.publicationDate = publicationDate;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public int getViewNumber() {
		return viewNumber;
	}

	public void setViewNumber(int viewNumber) {
		this.viewNumber = viewNumber;
	}

	public String getLocalisation() {
		return localisation;
	}

	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}



	

	

}

package com.thp.spring.simplecontext.entity.impl;



import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.thp.spring.simplecontext.entity.Announcement;

@Entity
@Table(name="announcement", schema = "public")

public class AnnouncementImpl implements Announcement, Serializable{
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int   id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="description")
	private String description;
	
	@Column(name="price")
	private double price;
	
	@Lob
	@Column(name="photo")
    private byte[] photo;
	
	@Column(name="datepublication")
	private String datePub; 
	
	@Column(name="isavailable")
	private boolean status;
	
	@Column(name="nbrviews")
	private int nbrViews;
	
	@Column(name="location")
	private String location;
	
	@ManyToOne
	@JoinColumn(name = "categoryid")
	private CategoryImpl category;
	
	@ManyToOne
	@JoinColumn(name = "userid")
	private UserImpl user;
	
	public AnnouncementImpl()
	{

	}

	public AnnouncementImpl(String title, String description, CategoryImpl category, double price, byte[] photo, String datePub,
			boolean status, int nbrViews, String location, UserImpl user) {
		
		this.title = title;
		this.description = description;
		this.category = category;
		this.price = price;
		this.photo = photo;
		this.datePub = datePub;
		this.status = status;
		this.nbrViews = nbrViews;
		this.location = location;
		this.user = user;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public String getDatePub() {
		return datePub;
	}

	public void setDatePub(String datePub) {
		this.datePub = datePub;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getNbrViews() {
		return nbrViews;
	}

	public void setNbrViews(int nbrViews) {
		this.nbrViews = nbrViews;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public CategoryImpl getCategory() {
		return category;
	}

	public void setCategory(CategoryImpl category) {
		this.category = category;
	}

	public UserImpl getUser() {
		return user;
	}

	public void setUser(UserImpl user) {
		this.user = user;
	}
	
	@Override
	public String toString() {
		return "AnnouncementImpl [id=" + id + ", title=" + title.trim() + ", description=" + description.trim() + ", price=" + price
				+ ", photo=" + photo + ", datePub=" + datePub.trim() + ", status=" + status + ", nbrViews=" + nbrViews
				+ ", location=" + location.trim() + ", category=" + category.toString() + ", user=" + user.toString() + "]";
	}
	
}

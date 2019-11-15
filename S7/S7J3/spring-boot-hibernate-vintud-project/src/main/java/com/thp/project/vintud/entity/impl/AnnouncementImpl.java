package com.thp.project.vintud.entity.impl;


import java.io.Serializable;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.thp.project.vintud.entity.Announcement;



@Entity
@Table(name = "announcement")

@NamedQueries({
		@NamedQuery(name = AnnouncementImpl.QN.FIND_Announcement_BY_ID, query = "SELECT a FROM AnnouncementImpl a WHERE id = :id"),

		@NamedQuery(name = AnnouncementImpl.QN.FIND_ALL_Announcement, query = "SELECT a FROM AnnouncementImpl a ")

})

public class AnnouncementImpl implements Serializable{
	public static class QN {
		public static final String FIND_Announcement_BY_ID = "AnnouncementImpl.getElement";
		// public static final String CREATE_MOUSSAILLON =
		// "Moussaillon.createMoussaillon";
		public static final String FIND_ALL_Announcement = "AnnouncementImpl.findAll";

	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "description")
	private String description;
	/*
	@Transient
	private int categoryId;
	*/
	@Column(name = "price")
	private float price;

	@Column(name = "picture")
	private String picture;
	
	@Column(name = "publication_date")
	private String publicationDate;
	
	@Column(name = "is_available")
	private boolean isAvailable;
	
	@Column(name = "view_number")
	private int viewNumber;
	
	@Column(name = "localisation")
	private String localisation;
	/*
	@Transient
	private int userId;
*/
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private CategoryImpl category ;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserImpl user  ;

	
	





	public boolean equals(int id) {

		return this.id == id;

	}

//methode toString

	public String toString() {
		return "l'annonce dont l'identifiant " + id + " a un titre : " + title + " , et une description : "
				+ description + " , dont son prix est �gale � : " + price;

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


	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public void setPicture(String picture) {

		this.picture = picture;
	}

	public String getPicture() {

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

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	


	

	

}

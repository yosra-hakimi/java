package com.thp.spring.simplecontext.entity.impl;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.thp.spring.simplecontext.entity.Favoris;

@Entity
@Table(name="favoris", schema = "public")
public class FavorisImpl implements Favoris, Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne
	@JoinColumn(name = "announcementid")
	private AnnouncementImpl announcement;
	
	@OneToOne
	@JoinColumn(name = "userid")
	private UserImpl user;
	
	@Column(name="dateofadd")
	private String dateFavoris;

	public FavorisImpl( )
	{

	}

	public FavorisImpl(String dateFavoris, int id) {
		
		this.dateFavoris = dateFavoris;
		this.id= id;

	}
	
	public  String getDateFavoris() {

		return dateFavoris;
	}

	public void setDateFavoris(String dateFavoris) {
		this.dateFavoris = dateFavoris;
	}

	public AnnouncementImpl getAnnouncement() {
		return announcement;
	}

	public void setAnnouncement(AnnouncementImpl announcement) {
		this.announcement = announcement;
	}

	public UserImpl getUser() {
		return user;
	}

	public void setUser(UserImpl user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}

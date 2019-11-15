package com.thp.project.vintud.entity.impl;

import java.sql.Date;


public class FavorisImpl {
	
	private int idUser;
	private int idAnnouncement;
	private Date dateOfAdd;
	
	
	
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public int getIdAnnouncement() {
		return idAnnouncement;
	}
	public void setIdAnnouncement(int idAnnouncement) {
		this.idAnnouncement = idAnnouncement;
	}
	public Date getDateOfAdd() {
		return dateOfAdd;
	}
	public void setDateOfAdd(Date dateOfAdd) {
		this.dateOfAdd = dateOfAdd;
	}

}

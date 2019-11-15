package com.thp.spring.simplecontext.entity.impl;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.thp.spring.simplecontext.entity.User;

@Entity
@Table(name="userr", schema = "public")
public class UserImpl implements User, Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int    id;
	
	@Column(name="mail")
	private String mail;
	
	@Column(name="firstname")
	private String firstName;
	
	@Column(name="name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "roleid")
	private RoleImpl role;
	
	@Column(name="pseudo")
	private String pseudo;
	
	@Column(name="userpassword")
	private String password;
	
	@Column(name="phone")
	private String phoneNumber;
	
	@Column(name="address")
	private String address;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	@JsonIgnore
	private Set<AnnouncementImpl> announcements = new HashSet<AnnouncementImpl>();
	
	public UserImpl()
	{

	}

	public UserImpl(String firstName, String name, RoleImpl role, String pseudo, String mail, String password, String phoneNumber,
					String address) {

		this.mail = mail;
		this.firstName = firstName;
		this.name = name;
		this.role = role;
		this.pseudo = pseudo;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.setAnnouncements( new HashSet<AnnouncementImpl>());
	}

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
	public Set<AnnouncementImpl> getAnnouncements() {
		return announcements;
	}

	public void setAnnouncements(Set<AnnouncementImpl> announcements) {
		this.announcements = announcements;
	}
	
	public RoleImpl getRole() {
		return role;
	}

	public void setRole(RoleImpl role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserImpl [id=" + id + ", mail=" + mail + ", firstName=" + firstName + ", name=" + name + ", role="
				+ role + ", pseudo=" + pseudo + ", password=" + password + ", phoneNumber=" + phoneNumber + ", address="
				+ address + "]";
	}
	
	

	

}

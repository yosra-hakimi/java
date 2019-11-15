package com.thp.project.vintud.entity.impl;

import java.io.Serializable;

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


@Entity
@Table(name="userr")

@NamedQueries({
	@NamedQuery(name = UserImpl.QN.FIND_USER_BY_MAIL, query = "SELECT u FROM UserImpl u WHERE mail = :mail")

	

})



public class UserImpl implements Serializable {

	public static class QN {
		public static final String FIND_USER_BY_MAIL = "UserImpl.getUserByMail";
	
		public static final String CREATE_USER = "UserImpl.createUser";
	}
	
	
		
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="firstname")
	private String firstname;
	
	@Column(name="name")
	private String name;
	
	@Column(name="pseudo")
	private String pseudo;
	
	@Column(name="mail")
	private String mail;
	
	@Column(name="u_password")
	private String uPassword;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="address")
	private String address;
	
	
	
	@ManyToOne
	@JoinColumn(name = "role_id")
	private RoleImpl role ;
	
	
	
	
	public RoleImpl getRole() {
		return role;
	}


	public void setRole(RoleImpl role) {
		this.role = role;
	}





	public UserImpl() {
		super();
	};



	

	public boolean equals(String mail, String uPassword) {

		return super.equals(this.mail == mail && this.uPassword == uPassword);

	}

//methode toString

	public String toString() {

		return ("Cet utilisateut qui a un identifiant " + this.id + " , a un pr�nom : " + firstname + ", un nom : " + name
				+ " , un pseudo : " + pseudo + " , une adresse mail : " + mail + " , un numero de telephone : " + phone
				+ " et une adresse : " + address);

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
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

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getuPassword() {
		return uPassword;
	}

	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


}

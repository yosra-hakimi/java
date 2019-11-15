package com.thp.project.vintud.entity.impl;

import com.thp.project.vintud.entity.User;

public class UserImpl implements User{

	private int id;
	private String firstname;
	private String name;
	private String pseudo;
	private String mail;
	private String uPassword;
	private String phone;
	private String address;
	private int roleId;

	public UserImpl() {
	};

	public UserImpl(String firstname, String name, String pseudo, String mail, String uPassword, String phone,

			String address, int roleId) {

		this.firstname = firstname;
		this.name = name;
		this.pseudo = pseudo;
		this.mail = mail;
		this.uPassword = uPassword;
		this.phone = phone;
		this.address = address;
		this.roleId = roleId;
	}

	

	public boolean equals(String mail, String uPassword) {

		return super.equals(this.mail == mail && this.uPassword == uPassword);

	}

//methode toString

	public String toString() {

		return ("Cet utilisateut qui a un identifiant " + this.id + " , a un prénom : " + firstname + ", un nom : " + name
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

	public int getroleId() {
		return roleId;
	}

	public void setroleId(int roleId) {
		this.roleId = roleId;
	}

}

package com.thp.project.vintud.entity;

public interface User {

	int getId();

	void setId(int id);

	String getFirstname();

	void setFirstname(String firstname);

	String getName();

	void setName(String name);

	String getPseudo();

	void setPseudo(String pseudo);

	String getMail();

	void setMail(String mail);

	String getuPassword();

	void setuPassword(String uPassword);

	String getPhone();

	void setPhone(String phone);

	String getAddress();

	void setAddress(String address);

	int getroleId();

	void setroleId(int roleId);

}

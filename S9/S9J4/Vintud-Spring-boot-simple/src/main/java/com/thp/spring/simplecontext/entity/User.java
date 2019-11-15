package com.thp.spring.simplecontext.entity;

import java.util.Set;
import com.thp.spring.simplecontext.entity.impl.AnnouncementImpl;
import com.thp.spring.simplecontext.entity.impl.RoleImpl;



public interface User {
	
	public String getMail() ;

	public void setMail(String mail);

	public String getFirstName();

	public void setFirstName(String firstName);

	public String getName();

	public void setName(String name);

	public String getPseudo();

	public void setPseudo(String pseudo);

	public String getPassword();

	public void setPassword(String password);

	public String getPhoneNumber();

	public void setPhoneNumber(String phoneNumber);

	public String getAddress();

	public void setAddress(String address);

	public RoleImpl getRole();

	/*public Set<AnnouncementImpl> getAnnouncements();

	public void setAnnouncements(Set<AnnouncementImpl> announcements);*/
	
	public String toString();
	
}

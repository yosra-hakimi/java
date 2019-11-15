package com.thp.spring.simplecontext.entity;

public interface Category {
	
	public int getId();
	
	public void setId(int id); 
	
	public String getCategoryName();

	public void setCategoryName(String categoryName);

	public String getCategoryDescription();

	public void setCategoryDescription(String categoryDescription);

	public String toString();

}

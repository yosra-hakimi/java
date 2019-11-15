package com.thp.spring.simplecontext.entity.impl;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.thp.spring.simplecontext.entity.Category;

@Entity
@Table(name="category", schema = "public")

public class CategoryImpl implements Category, Serializable {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int    id;
	
	@Column(name="name")
	private String categoryName;
	@Column(name = "description")
	private String categoryDescription;

	
	
	public CategoryImpl() {

	}

	public CategoryImpl(int id, String categoryName, String categoryDescription) {

		this.categoryName = categoryName;
		this.categoryDescription = categoryDescription;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategoryName()
	{
		return categoryName;
	}

	public void setCategoryName(String categoryName)
	{
		this.categoryName = categoryName;
	}

	public String getCategoryDescription()
	{
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription)
	{
		this.categoryDescription = categoryDescription;
	}

	public String toString()
	{
		return "CategoryImpl [categoryName=" + categoryName + ", categoryDescription=" + categoryDescription + "]";
	}

}

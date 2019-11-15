package com.thp.project.vintud.entity.impl;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;





@Entity
@Table(name="category")
public class CategoryImpl  implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;

	//@OneToMany( mappedBy="category")
	//private Set<AnnouncementImpl> announcement = new HashSet<AnnouncementImpl>();

	
	public CategoryImpl(int id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}



	public CategoryImpl() {
		super();
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}

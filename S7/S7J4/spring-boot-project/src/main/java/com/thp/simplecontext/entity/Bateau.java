package com.thp.simplecontext.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="bateau",schema="moussaillonjdbc")
public class Bateau implements Serializable {
	
	public static class QN {
	    public static final String FIND_BY_ID = "Bateau.findById";
	}
	
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
     private int  id;
	
	@Column(name="name")
	private String name ;
	
	@Column(name="type")
	private String type ;
	
	@Column(name="size")
	private double size ;
	
	
	@OneToMany( mappedBy="bateau")
	private Set<Moussaillon> moussaillons = new HashSet<Moussaillon>();


	//private List<Moussaillon> moussaillons = new ArrayList<Moussaillon>();

/*
public List<Moussaillon> getMoussaillons() {
		return moussaillons;
	}



	public void setMoussaillons(List<Moussaillon> moussaillons) {
		this.moussaillons = moussaillons;
	}
	*/
	
	
	public void setSize(double size) {
		this.size = size;
	}
public Bateau(int id, String name, String type, int size) {
	super();
	this.id = id;
	this.name = name;
	this.type = type;
	this.size = size;
}
public Bateau () {
	
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
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public double getSize() {
	return size;
}
public void setTaille(int size) {
	this.size = size;
}
@Override
public String toString() {
	return "Bateau [id=" + id + ", name=" + name.trim() + ", type=".trim() + type.trim() + ", taille="+ size + "]";
}






















}

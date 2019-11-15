package com.thp.springmvc.entity;

public class Bateau {
	
	
private int  id;
private String name ;
private String type ;
private double size ;


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

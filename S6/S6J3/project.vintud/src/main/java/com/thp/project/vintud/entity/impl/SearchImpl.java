package com.thp.project.vintud.entity.impl;

public class SearchImpl {

	private String clothType;
	private String size;
	private String color;
	private float minPrice;
	private float maxPrice;
	private int sellerId;
	private int userId;
	private int id;

	public String getClothType() {
		return clothType;
	}

	public void setClothType(String clothType) {
		this.clothType = clothType;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public float getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(float minPrice) {
		this.minPrice = minPrice;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public float getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(float maxPrice) {
		this.maxPrice = maxPrice;
	}

	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String toString() {
		String search = "you search a ";
		
		
		if(clothType!="") search += clothType;
		if(color!="") search += " color is "+color;
		if(size!="") search += " size is "+size;
		if(maxPrice!=0) search += " max price is "+maxPrice;
		if(minPrice!=0) search += " min price is "+maxPrice;
		if(sellerId!=0) search += " annoucement of the seller with id "+sellerId;
		
		
		return search;
	}

	public int getuserId() {
		return userId;
	}

	public void setuserId(int userId) {
		this.userId = userId;
	}

}

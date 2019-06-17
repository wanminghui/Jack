package com.woniuxy.sellphone.DAO.po;

public class goodsPO {

	private int goodID;
	private String goodname;
	private int price;
	private int total;
	private String picture;
	private String describute;
	private int goodtypeID;
	public int getGoodID() {
		return goodID;
	}
	public void setGoodID(int goodID) {
		this.goodID = goodID;
	}
	public String getGoodname() {
		return goodname;
	}
	public void setGoodname(String goodname) {
		this.goodname = goodname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getDescribute() {
		return describute;
	}
	public void setDescribute(String describute) {
		this.describute = describute;
	}
	public int getGoodtypeID() {
		return goodtypeID;
	}
	public void setGoodtypeID(int goodtypeID) {
		this.goodtypeID = goodtypeID;
	}
	@Override
	public String toString() {
		return "goodsPO [goodID=" + goodID + ", goodname=" + goodname + ", price=" + price + ", total=" + total
				+ ", picture=" + picture + ", describute=" + describute + ", goodtypeID=" + goodtypeID + "]";
	}
	
	
	
	
	
	
	
	
}

package com.woniuxy.sellphone.DAO.po;

public class vi_knowpo {
	
	private String goodname;//��Ʒ��
	private String picture;//��ƷͼƬ��ַ
	private String goodID;//��ƷID
	private int number;  //����Ĵ�����
	private int price;//��Ʒ�۸�
	public String getGoodname() {
		return goodname;
	}
	public void setGoodname(String goodname) {
		this.goodname = goodname;
	}
	public String getPicture() {
		return picture;
	}
	public vi_knowpo(String goodname, String picture, String goodID, int number, int price) {
		
		this.goodname = goodname;
		this.picture = picture;
		this.goodID = goodID;
		this.number = number;
		this.price = price;
	}
	public vi_knowpo() {
		
		
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getGoodID() {
		return goodID;
	}
	public void setGoodID(String goodID) {
		this.goodID = goodID;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "vi_knowpo [goodname=" + goodname + ", picture=" + picture + ", goodID=" + goodID + ", number=" + number
				+ ", price=" + price + "]";
	}
	
	

	 
	
	

}

package com.wishlist.wishlist.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Product {

	long productID;
	String productDescription;
	double price;
	int rating;
	long wishListID;
	
	
	
	public Product (){
		
	}
	public Product(long productID, String productDescription, double price,
			int rating) {
		
		this.productID = productID;
		this.productDescription = productDescription;
		this.price = price;
		this.rating = rating;
	}
	public long getProductID() {
		return productID;
	}
	public void setProductID(long productID) {
		this.productID = productID;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}

	public long getWishListID() {
		return wishListID;
	}
	public void setWishListID(long wishListID) {
		this.wishListID = wishListID;
	}
}

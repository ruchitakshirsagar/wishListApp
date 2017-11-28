package com.wishlist.wishlist.database;

import java.util.HashMap;
import java.util.Map;

import com.wishlist.wishlist.model.Product;

public class DataBaseClass {
	
	private static Map<Long,Product> productsInWishList = new HashMap<>();
	
	private static Map<Long,Product> productsInDB = new HashMap<>();
	
	
	public static Map<Long, Product> getProductsFromWishList(){
		return productsInWishList;
	}

	public static Map<Long,Product> getProductsFromDB(){
		Product p1= new Product(1L,"Shoes", 20.50, 3);
		Product p2= new Product(2L,"Bag", 40.50, 5);
		Product p3= new Product(3L,"Jacket", 30.50, 4);
		Product p4= new Product(4L,"Cap", 10.50, 3);
		
		productsInDB.put(1L, p1);
		productsInDB.put(2L, p2);
		productsInDB.put(3L, p3);
		productsInDB.put(4L, p4);
		
		return productsInDB;
	}
}

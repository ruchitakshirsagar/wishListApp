package com.wishlist.wishlist.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.wishlist.wishlist.database.DataBaseClass;
import com.wishlist.wishlist.model.Product;

public class ProductService {
	
	private Map<Long,Product> productsInWishList = DataBaseClass.getProductsFromWishList();
	private Map<Long,Product> productsInDB = DataBaseClass.getProductsFromDB();

	public List<Product> getAllProductsFromDB(){

		return new  ArrayList<Product>(productsInDB.values());
		
	}
	
public List<Product> getAllProductsFromWishList(){
	
	System.out.println(productsInWishList.values());
		
	return new  ArrayList<Product>(productsInWishList.values());
		
	}

public Product getProductFromDB(long id){
	
	return productsInDB.get(id);
}

public Product addProductToWishList(Product product){
	product.setWishListID(productsInWishList.size() +1);
	
	if(null!=getProductFromDB(product.getProductID())){
		
	return 	productsInWishList.put(product.getWishListID(),product);
	}
	return null;
}

public Product removeProductFromWishlist(long id){
	
	return productsInWishList.remove(id);
	
	
}
}

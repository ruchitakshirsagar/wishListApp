package com.wishlist.wishlist.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.wishlist.wishlist.model.Product;
import com.wishlist.wishlist.service.ProductService;

@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
public class ProductResources {
	
	ProductService productService = new ProductService();
	
	
	@GET
	public List<Product> getAllProducts(){
		return productService.getAllProductsFromDB();
	}

	
	
	@GET
	@Path("/{productID}")
	public Product getProduct(@PathParam("productID") long id){
		return productService.getProductFromDB(id);
		
	}
}

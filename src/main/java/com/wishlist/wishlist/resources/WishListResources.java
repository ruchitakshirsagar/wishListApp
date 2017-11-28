package com.wishlist.wishlist.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.wishlist.wishlist.model.Product;
import com.wishlist.wishlist.service.ProductService;

@Path("/wishList")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class WishListResources {
	
	ProductService productService = new ProductService();
	
	@POST
	public Product addProductInWishList(Product product){
		
		return productService.addProductToWishList(product);
	}
	
	@GET
	public List<Product> getAllProductsInWishList(){
		return productService.getAllProductsFromWishList();
	}
	
	@DELETE
	@Path("/{wishListID}")
	public void removeProductfromWishList(@PathParam("wishListID") long id){
		 productService.removeProductFromWishlist(id);
		 System.out.println("In remove " + productService.removeProductFromWishlist(id) );
	}
	
	

}

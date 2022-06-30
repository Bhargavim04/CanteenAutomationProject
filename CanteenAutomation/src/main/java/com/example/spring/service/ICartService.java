package com.example.spring.service;

import java.util.List;

import com.example.spring.entity.Cart;
import com.example.spring.entity.FoodItem;
import com.example.spring.exception.CartNotFoundException;

public interface ICartService {
	
	List<Cart> getAllCartItems();
	Cart updateItemById(Cart cart, int cartId);
	Cart deleteItem(int cartId) throws CartNotFoundException;
	Cart updateCartPrice(int cartId, int cartTotal) throws CartNotFoundException;
	Cart addItemToCart(Cart foodItem) throws CartNotFoundException;
//	Cart updateItemId(int cartId, int itemId);
	Cart getCartById(int cartId) throws CartNotFoundException;
	
	
	
	//Test Case Methods
//	Cart updateCartTotal(int cartId, int cartTotal);
	
	

}

package com.example.spring.service;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.spring.entity.CanteenFood;
import com.example.spring.entity.Cart;
import com.example.spring.exception.CartNotFoundException;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class CartServiceTest {
	
	@Autowired
	ICartService cartServ;
	
	
	//update item from cart
	@Test
	@Disabled
	void testUpdateCartTotal() throws CartNotFoundException{
		Cart cart = cartServ.updateCartPrice(31, 2000);
		assertEquals(31, cart.getCartId());
		
	}
	
	//delete item from cart
	@Test
	@Disabled
	void testDeleteItemFromCart() throws CartNotFoundException {
		Cart cart = cartServ.deleteItem(30);
		assertEquals(30, cart.getCartId());
		
	}
	
	@Test
	@Disabled
	void testGetAllItemsFromCart() {
		List<Cart> items = cartServ.getAllCartItems();
		//if size of cart is two then test case will pass else fail
		assertEquals(3, items.size());
		//access first item of the list of items
		Cart cartitem = items.get(0);
		//access or get item based on cartId
		assertEquals(31, cartitem.getCartId());
		
		
	}

}

package com.example.spring.service;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.spring.entity.Cart;
import com.example.spring.exception.CartNotFoundException;
import com.example.spring.repository.ICartRepository;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
public class CartServiceMockitoTest {
	
	//@InjectMock - creates instance of a class and injects mocks that are created 
        //with @Mock
	
//	@InjectMocks
//	ICartService cartServ;
	
	@InjectMocks
	CartServiceImpl cartServ;
	
	//MockBean creates mock of a class or interface
	
	@MockBean     //MockBean act as a repository because we don't have the repository in mockito 
	ICartRepository cartRepo;
	
	//Initialization of mock objects
	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	
	//test on get
	@Test
	void testGetItemById() throws CartNotFoundException {
		Cart cartItem = new Cart();
		cartItem.setCartId(10);
		cartItem.setCartTotal(2000);
		
		Mockito.when(cartRepo.findById(10)).thenReturn(Optional.of(cartItem));
		Cart item = cartServ.getCartById(10);
		
		assertEquals(10, item.getCartId());
		assertEquals(2000, item.getCartTotal());
	}
	
	//test on update
	@Test
	void testUpdateCartItem() throws CartNotFoundException {
		Cart cartItem = new Cart();
		cartItem.setCartId(10);
		cartItem.setCartTotal(2000);
		
		Cart updatedItem = new Cart();
		updatedItem.setCartId(10);
		updatedItem.setCartTotal(5000);
		
		Mockito.when(cartRepo.findById(10)).thenReturn(Optional.of(cartItem));
		Mockito.when(cartRepo.save(cartItem)).thenReturn(updatedItem);
		
		Cart cart = cartServ.updateCartPrice(10, 5000);
		assertEquals(5000, cart.getCartTotal());
	}
	
	@Test
	void testAddItemToCart() throws CartNotFoundException {
		Cart cartItem = new Cart();
		cartItem.setCartId(10);
		cartItem.setCartTotal(2000);
		
		
		Mockito.when(cartRepo.save(cartItem)).thenReturn(cartItem);
		Cart cart1 = cartServ.addItemToCart(cartItem);
		
		assertEquals(2000, cart1.getCartTotal());
	}
	
	@Test
	void testDeleteItemFromCart() throws CartNotFoundException{
		Cart cartItem = new Cart();
		cartItem.setCartId(10);
		cartItem.setCartTotal(2000);
		
		Mockito.when(cartRepo.save(cartItem)).thenReturn(cartItem);
		Cart cart = cartServ.deleteItem(10);
		
		assertEquals(10, cart.getCartId());
	}
	
}

package com.example.spring.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.entity.Cart;
import com.example.spring.exception.CartNotFoundException;
import com.example.spring.service.ICartService;

@RestController
public class CartController {

	@Autowired
	ICartService cartServ;

	// add item to cart
	@PostMapping("/additem")
	ResponseEntity<Cart> addItemToCart(@Valid @RequestBody Cart foodItem) throws CartNotFoundException {
		Cart item = cartServ.addItemToCart(foodItem);
		return new ResponseEntity<>(item, HttpStatus.OK);
	}

	// view or get all items from cart
	@GetMapping("/cartitems")
	ResponseEntity<List<Cart>> getAllCartItems() {
		List<Cart> cart = cartServ.getAllCartItems();
		return new ResponseEntity<>(cart, HttpStatus.OK);
	}

	// get item by cartId
	@GetMapping("/cartitem/{id}")
	ResponseEntity<Cart> getCartById(@PathVariable("id") int cartId) throws CartNotFoundException {
		Cart cart = cartServ.getCartById(cartId);
		return new ResponseEntity<>(cart, HttpStatus.OK);
	}

	// delete item from cart
	@DeleteMapping("/deleteitem/{id}")
	ResponseEntity<Cart> deleteCartItem(@PathVariable("id") int cartId) throws CartNotFoundException {
		Cart cart = cartServ.deleteItem(cartId);
		return new ResponseEntity<>(cart, HttpStatus.OK);
	}

	// update item from cart base on id
	@PutMapping("/updateitem/{id}")
	ResponseEntity<Cart> updateItemById(@RequestBody Cart cart, @PathVariable("id") int cartId) {
		Cart updatedCart = cartServ.updateItemById(cart, cartId);
		return new ResponseEntity<>(updatedCart, HttpStatus.OK);

	}

	// update item totalprice
	@PatchMapping("/updateitem/{id}")
	ResponseEntity<Cart> updateCartByTotalPrice(@PathVariable("id") int cartId, int cartTotal)
			throws CartNotFoundException {
		Cart updatedItem = cartServ.updateCartPrice(cartId, cartTotal);
		return new ResponseEntity<>(updatedItem, HttpStatus.OK);
	}


}

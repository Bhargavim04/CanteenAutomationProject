package com.example.spring.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.spring.entity.Cart;
import com.example.spring.entity.FoodItem;
import com.example.spring.exception.CartNotFoundException;
import com.example.spring.repository.ICartRepository;

@Service
public class CartServiceImpl implements ICartService {

	@Autowired
	ICartRepository cartRepo;
	
	@Override
	public Cart addItemToCart(Cart foodItem) throws CartNotFoundException {
		return cartRepo.save(foodItem);
	}
	
	@Override
	public List<Cart> getAllCartItems() {
		return cartRepo.findAll();
	}
	
	@Override
	public Cart updateItemById(Cart cart, int cartId) {
	
		Optional<Cart> dbItem = cartRepo.findById(cartId);
		if(dbItem.isPresent()) {
			return cartRepo.save(cart);
		} else {
			return null;
		}
	}

	@Override
	public Cart deleteItem(int cartId) throws CartNotFoundException {
		Optional<Cart> cart = cartRepo.findById(cartId);
		if(cart.isPresent()) {
			cartRepo.deleteById(cartId);
		} else {
			throw new CartNotFoundException("Cart not found with cartid "+cartId);
		}
		return cart.get();
	}
	
	@Override
	public Cart updateCartPrice(int cartId, int cartTotal) throws CartNotFoundException {
		Optional<Cart> cart = cartRepo.findById(cartId);
		if(cart.isPresent()) {
			//update quantity
			Cart dbItem = cart.get();
			dbItem.setCartTotal(cartTotal);
			return cartRepo.save(dbItem);
		} else {
			throw new CartNotFoundException("Cart not found with cartid "+cartId);
		}
	}

	@Override
	public Cart getCartById(int cartId) throws CartNotFoundException {
		Optional<Cart> cart = cartRepo.findById(cartId);
		if(cart.isPresent()) {
			return cart.get();
		} else {
			throw new CartNotFoundException("Cart not found with cartid "+cartId);
		}
	}


	//Test case method implementation
//	@Override
//	public Cart updateCartTotal(int cartId, int cartTotal) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	//Test case method implementation
	
//	@Override
//	public List<FoodItem> getCartItems() {
//		//logic to fetch cart item
//		
//		return null;
//	}

	
//	@Override
//	public Cart updateItemId(int cartId, int itemId) {
//		Optional<Cart> cart = cartRepo.findById(cartId);
//		if(cart.isPresent()) {
//			//update quantity
//			Cart dbItem = cart.get();
//			dbItem.setItemId(itemId);
//			return cartRepo.save(dbItem);
//		} else {
//		return null;
//		}
//	}

	

}

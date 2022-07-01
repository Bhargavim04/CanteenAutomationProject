package com.example.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.entity.Card;
import com.example.spring.exception.CardNotFoundException;
import com.example.spring.service.ICardService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;



@RestController

public class CardController {
	
	
	@Autowired
	ICardService cardserve;
	//get all card details
	
	
//create card rest api
	@PostMapping("/CardDetails")
	
	ResponseEntity<Card>addCard(@RequestBody Card card) {
		Card newCard= cardserve.addCard(card);
		return new ResponseEntity<>(newCard,HttpStatus.CREATED);
	}
	//get card by id rest api
	@GetMapping("/CardDetails/{id}")
	ResponseEntity<Card> getByCardId(@PathVariable("id") int cardId) throws CardNotFoundException {
		Card newCard=cardserve.getByCardId(cardId);
		return new ResponseEntity<>(newCard,HttpStatus.OK);
	}
		
	
	//update card rest api
	@PatchMapping("/CardDetails/{id}")
	ResponseEntity<Card> updateCard(@RequestBody Card card, @PathVariable("id") int cardId) throws CardNotFoundException  {
		Card card1=cardserve.updateCard(card, cardId);
		return new ResponseEntity<>(card1,HttpStatus.OK);
	}
	//delete card rest api
	@DeleteMapping("/CardDetails/{id}")
	ResponseEntity<Card> deleteCard(@PathVariable("id") int cardId) throws CardNotFoundException  {
		Card card=cardserve.deleteCard(cardId);
		return new ResponseEntity<>(card,HttpStatus.OK);
	  }

	}


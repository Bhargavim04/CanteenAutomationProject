package com.example.spring.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.spring.entity.Card;
import com.example.spring.exception.CardNotFoundException;
import com.example.spring.repository.ICardRepository;
@ExtendWith(SpringExtension.class)

public class CardServiceMockitoTestTest {

	@InjectMocks
	CardServiceImplementation cardserv;

	// @MockBean - Creates Mock of a class or interface
	@MockBean
	ICardRepository cardrepo;

	// Initialization of mock objects
	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	void testGetCardById() throws CardNotFoundException {

		Card card = new Card();
		card.setCardId(10);
		card.setCardHolderName("Raja");

		Mockito.when(cardrepo.findById(10)).thenReturn(Optional.of(card));

		Card card1 = cardrepo.getCardId(10);
		assertEquals(10, card1.getCardId());
		assertEquals("Raja", card1.getCardHolderName());
	}
	
	@Test
	void testGetAllCardDetails() {
		List<Card> cardList = new ArrayList<Card>();
		List<Card> cardList1 = new ArrayList<Card>();
		Card card = new Card();
		card.setCardId(10);
		card.setCardHolderName("Rani");
		cardList.add(card);
		Mockito.when(cardrepo.findAll()).thenReturn(cardList);
		cardList1= cardserv.getAllCardDetails();
		assertEquals(cardList, cardList1);
	}
	
	@Test
	void testAddCard() {
		Card card = new Card();
		card.setCardId(12);
		card.setCardHolderName("Ram");
		
		Mockito.when(cardrepo.save(card)).thenReturn(card);
		Card c1= cardserv.addCard(card);
		assertEquals("Ram", c1.getCardHolderName());
	}
	
	
		
		
	
		
	
	
	@Test
	void testDeleteCard() throws CardNotFoundException {
		Card card = new Card();
		card.setCardId(20);
		card.setCardHolderName("Ravi");
		
		Mockito.when(cardrepo.findById(20)).thenReturn(Optional.of(card));
		//Mockito.when(empRepo.deleteById(10)).
		Card card1= cardserv.deleteCard(20);
		assertEquals(20, card1.getCardId());
		
	}
}

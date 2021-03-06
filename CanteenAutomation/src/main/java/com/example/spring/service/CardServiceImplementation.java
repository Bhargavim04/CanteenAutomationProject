package com.example.spring.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring.entity.Card;
import com.example.spring.exception.CardNotFoundException;
import com.example.spring.repository.ICardRepository;

@Service
public class CardServiceImplementation implements ICardService {
	@Autowired
	ICardRepository cardRepository;

	@Override
	public Card addCard(Card card) {

		return cardRepository.save(card);
	}

	@Override
	public Card getByCardId(int cardId) throws CardNotFoundException {

		Optional<Card> card = cardRepository.getByCardId(cardId);
		if (card.isPresent()) {
			return card.get();
		} else {
			throw new CardNotFoundException("Card not found with  id " + cardId);
		}
	}

	@Override
	public Card updateCard(Card card, int cardId) {
		Optional<Card> card1 = cardRepository.getByCardId(cardId);
		if (card1.isPresent()) {
			return cardRepository.save(card);
		} else {
			return null;
		}
	}

	@Override
	public Card deleteCard(int cardId) throws CardNotFoundException {
		Optional<Card> card2 = cardRepository.getByCardId(cardId);
		if (card2.isPresent()) {
			cardRepository.deleteById(cardId);
		} else {
			throw new CardNotFoundException("card not found with  id " + cardId);
		}
		return card2.get();

	}

}

package com.example.spring.service;
import com.example.spring.entity.Card;
public interface ICardService {

	//get all cardDetails
	/*List<Card> getAllCardDetails();
	
	List<Card> getCardHolderName(String cardHolderName);
	List<Card> getCardNo(long cardNo);
	List<Card> getCardBankName(String cardBankName);
	List<Card> getCvv(int cvv);*/
	Card getByCardId(int cardId);
	
	Card addCard(Card card);

	Card updateCard(Card card, int cardId);

	Card deleteCard(int cardId);

	
}

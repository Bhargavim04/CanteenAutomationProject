package com.example.spring.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring.entity.Card;

@Repository
public interface ICardRepository extends JpaRepository<Card, Integer>{

	Optional<Card> getByCardId(int cardId);
	//Card getCardId(int cardId);

	Card getByCardId(String cardHolderName);

	List<Card> findByCardNo(int cardNo);

	List<Card> findByCardBankName(String cardBankName);

	List<Card> findByCvv(int cvv);

	Card deleteById(int cardId);

	

	

}

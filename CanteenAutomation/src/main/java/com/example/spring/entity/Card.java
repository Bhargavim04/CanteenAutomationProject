package com.example.spring.entity;

import javax.persistence.Table;

import lombok.Data;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@Table(name="CardDetails")
public class Card {
	@Id
	@GeneratedValue
	private int cardId;
	@Column(name="cardHolderName")
	private String cardHolderName;
	@Column(name="cardNo")
	private int cardNo;
	@Column(name="cardBnakName")
	private String cardBankName;
	@Column(name="expDate")
	private String expDate;
	@Column(name="cvv")
	private int cvv;
	
		
	
	
	public Card()
	{
		
	}
	public Card(String cardHolderName, int cardNo, String cardBnakName, String expDate, int cvv) {
		super();
		this.cardHolderName = cardHolderName;
		this.cardNo = cardNo;
		this.cardBankName = cardBnakName;
		this.expDate = expDate;
		this.cvv = cvv;
	}
	public long getCardId() {
		return cardId;
	}
	public void setCardId(int cardId) {
		this.cardId = cardId;
	}
	public String getCardHolderName() {
		return cardHolderName;
	}
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}
	public long getCardNo() {
		return cardNo;
	}
	public void setCardNo(int cardNo) {
		this.cardNo = cardNo;
	}
	public String getCardBnakName() {
		return cardBankName;
	}
	public void setCardBnakName(String cardBnakName) {
		this.cardBankName = cardBnakName;
	}
	public String getExpDate() {
		return expDate;
	}
	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	public void setCardTotal(int i) {
		// TODO Auto-generated method stub
		
	}
	
	public Card thenReturn(Card updatedCardId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Integer getByCardId() {
		// TODO Auto-generated method stub
		return null;
	}
	/*public String getCardBankName() {
		return cardBankName;
	}
	public void setCardBankName(String cardBankName) {
		this.cardBankName = cardBankName;
	}*/
	
	
	

}

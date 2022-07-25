package com.example.spring.entity;

import javax.persistence.Table;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
	private LocalDate expDate;
	
	@Column(name="cvv")
	private int cvv;
	

	@OneToMany(targetEntity=Payment.class,cascade=CascadeType.ALL)
	@JoinColumn(name="paycard_fk" ,referencedColumnName="cardId")
	private List<Payment> payment;
	
    @ManyToOne( cascade = CascadeType.ALL)
    @JoinColumn(name="cardcus_id")
    private Customer customer;

}

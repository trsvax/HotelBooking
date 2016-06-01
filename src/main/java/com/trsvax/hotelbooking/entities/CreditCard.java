package com.trsvax.hotelbooking.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.apache.tapestry5.beaneditor.NonVisual;

@Entity
public class CreditCard {
		
	@Id 
	@GeneratedValue
	@NonVisual
	public Long id;
	
	public String creditCardNumber;

	public CreditCardType creditCardType;

	public String creditCardName;

	public int creditCardExpiryMonth;

	public int creditCardExpiryYear;

	
}

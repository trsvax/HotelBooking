package com.trsvax.hotelbooking.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Address {
		
	@Id 
	@GeneratedValue
	public Long id;

	public String street;
	
	public String city;
	
	public String state;
	
	public String zip;
	
	public String country;
	

	
}

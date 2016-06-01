package com.trsvax.hotelbooking.entities;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Hotel {
		
	@Id 
	@GeneratedValue
	public Long id;

	public String name;
	
	@ManyToOne(fetch=FetchType.LAZY)
	public Address address;
	
	public Integer stars;
	
	public BigDecimal price;	
	
}

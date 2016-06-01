package com.trsvax.hotelbooking.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

import org.apache.tapestry5.beaneditor.NonVisual;

import com.trsvax.jacquard.jsr303.DateRange;

@Entity
@DateRange(start="checkinDate", end="checkoutDate")
public class Booking {
	
	@Id 
	@GeneratedValue
	@NonVisual
	public Long id;
	
	@ManyToOne
	public User user;
	
	@ManyToOne
	public Hotel hotel;
	
	@Future
	@NotNull
	public Date checkinDate;
	
	@NotNull
	public Date checkoutDate;
	
	@ManyToOne(cascade={CascadeType.ALL})
	public CreditCard creditCard;
	
	public boolean smoking;
	
	public int beds;
	
	public Date bookingDate;

	
}

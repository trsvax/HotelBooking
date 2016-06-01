package com.trsvax.hotelbooking.pages.hotel.booking;

import org.apache.tapestry5.annotations.ActivationRequestParameter;
import org.apache.tapestry5.annotations.PageActivationContext;
import org.apache.tapestry5.annotations.Property;

import com.trsvax.hotelbooking.entities.Booking;

public class BookingView {
	@PageActivationContext
	@Property
	Booking booking;
	
	@ActivationRequestParameter
	@Property
	String status;

}

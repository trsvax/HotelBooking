package com.trsvax.hotelbooking.pages.email;

import org.apache.tapestry5.annotations.PageActivationContext;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

import com.trsvax.hotelbooking.entities.Booking;
import com.trsvax.hotelbooking.services.EmailService;
import com.trsvax.jacquard.services.WebService;


public class BookingEmail {
	
	@PageActivationContext
	@Property
	Booking booking;
	
	@Inject
	WebService webService;
	
	@Inject
	EmailService emailService;
	
	
	void onSend() {		
		emailService.sendEmail(booking.user.email, "", "Confirmation", body(booking));
	}
	
	public String body(Booking booking) {
		this.booking = booking;
		return webService.content(BookingEmail.class);
	}
	
}

package com.trsvax.hotelbooking.pages.hotel.booking;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.PageActivationContext;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;

import com.trsvax.hotelbooking.entities.Booking;
import com.trsvax.hotelbooking.entities.Hotel;
import com.trsvax.hotelbooking.services.HotelService;

@RequiresRoles("user")
public class BookingNew {
	
	@Property
	@PageActivationContext
	Hotel hotel;
	
	@Property
	Booking booking;
	
	@Property
	Object row;
	
	@Inject
	HotelService hotelService;
	
	@InjectPage
	BookingView bookingView;
	
	@CommitAfter
	Object onSuccess()  {	
		booking.hotel = hotel;
		bookingView.status = hotelService.newBooking(booking);
		bookingView.booking = booking;
		return bookingView;
	}

}

package com.trsvax.hotelbooking.mixins;

import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.SetupRender;
import org.apache.tapestry5.ioc.annotations.Inject;

import com.trsvax.hotelbooking.Listing;
import com.trsvax.hotelbooking.entities.Booking;
import com.trsvax.hotelbooking.entities.User;
import com.trsvax.hotelbooking.services.DAO;

public class PendingBookingsByUser {
	
	@Parameter
	User user;
	
	@Inject
	Listing listing;
	
	@Inject
	DAO dao;
	
	@SetupRender
	void setupRender() {
		listing.setListing(dao.query(Booking.class, "from Booking where user = :user", "user",user));
	}

}

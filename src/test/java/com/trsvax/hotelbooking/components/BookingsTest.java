package com.trsvax.hotelbooking.components;

import static org.junit.Assert.*;

import org.junit.Test;

import com.trsvax.hotelbooking.entities.Booking;
import com.trsvax.hotelbooking.services.DAOsImple;

public class BookingsTest {

	@Test
	public void setupRender() {
		Bookings listing = new Bookings();
		listing.dao = new DAOsImple(new Booking());
		listing.setupRender();
		assertTrue(listing.bookings.size() > 0);
	}
	
	@Test
	public void getFormat() {
		Bookings listing = new Bookings();
		assertTrue(listing.getFormat() != null);
	}
	
	@Test
	public void getValues() {
		Bookings listing = new Bookings();
		listing.titleString = "title";
		assertTrue(listing.getValue().length > 0);
	}

}

package com.trsvax.hotelbooking.pages.hotel.booking;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.trsvax.hotelbooking.entities.Booking;
import com.trsvax.hotelbooking.entities.Hotel;
import com.trsvax.hotelbooking.services.HotelService;

public class BookingNewTest {

	@Test
	public void activate() {
		BookingNew page = new BookingNew();
		assertTrue(page.hotel == null);	
	}
	
	private Booking bookingTest;
	
	@Test
	public void onSuccess() {
		BookingNew page = new BookingNew();
		page.hotel = new Hotel();
		page.booking = new Booking();
		page.bookingView = new BookingView();
		page.hotelService = new HotelService() {
			
			@Override
			public String newBooking(Booking booking) {
				bookingTest = booking;
				return "Confirmed";
			}
		};
		page.onSuccess();
		assertTrue(bookingTest == page.booking);
		assertTrue(page.bookingView.booking == bookingTest);
		assertTrue(page.bookingView.status.equals("Confirmed"));
	}

}

package com.trsvax.hotelbooking.pages.hotel.booking;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BookingViewTest {

	@Test
	public void activate() {
		BookingView page = new BookingView();
		assertTrue( page.booking == null);	
		assertTrue( page.status == null);
	}

}

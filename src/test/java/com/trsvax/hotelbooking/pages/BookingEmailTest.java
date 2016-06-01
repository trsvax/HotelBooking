package com.trsvax.hotelbooking.pages;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.trsvax.hotelbooking.pages.email.BookingEmail;

public class BookingEmailTest {

	@Test
	public void test() {
		BookingEmail page = new BookingEmail();
		assertTrue(page != null);
	}

}

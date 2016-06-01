package com.trsvax.hotelbooking.mixins;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.trsvax.hotelbooking.Listing;
import com.trsvax.hotelbooking.entities.Booking;
import com.trsvax.hotelbooking.services.DAOsImple;

public class PendingBookingsByUserTest {
	
	private List<Booking> listingsTest;

	@Test
	public void setupRender() {
		PendingBookingsByUser pendingBookingsByUser = new PendingBookingsByUser();
		pendingBookingsByUser.dao = new DAOsImple(new Booking());
		pendingBookingsByUser.listing = new Listing() {
			
			@SuppressWarnings("unchecked")
			@Override
			public void setListing(Object listings) {
				listingsTest = (List<Booking>) listings;
			}
		};
		pendingBookingsByUser.setupRender();
		assertTrue(listingsTest.size() == 1);
	}

}

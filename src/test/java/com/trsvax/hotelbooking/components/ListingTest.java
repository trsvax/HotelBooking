package com.trsvax.hotelbooking.components;

import static org.junit.Assert.*;

import org.junit.Test;

public class ListingTest {

	@Test
	public void listings() {
		String listings = "listings";
		Listing listing = new Listing();
		listing.setListing(listings);
		assertTrue(listing.listings.equals(listings));
	}
	
	@Test
	public void getFormat() {
		Listing listing = new Listing();
		assertTrue(listing.getFormat() != null);
	}
	
	@Test
	public void getValues() {
		Listing listing = new Listing();
		listing.titleString = "title";
		assertTrue(listing.getValue().length > 0);
	}


}

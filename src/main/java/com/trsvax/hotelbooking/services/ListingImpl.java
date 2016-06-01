package com.trsvax.hotelbooking.services;

import org.apache.tapestry5.ComponentResources;

import com.trsvax.hotelbooking.Listing;

public class ListingImpl implements Listing {
	
	private final ComponentResources componentResources;
	
	public ListingImpl(ComponentResources componentResources) {
		this.componentResources = componentResources;
	}

	@Override
	public void setListing(Object listings) {
		((Listing)componentResources.getContainer()).setListing(listings);
	}

}

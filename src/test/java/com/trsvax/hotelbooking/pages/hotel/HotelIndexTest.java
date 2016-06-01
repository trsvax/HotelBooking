package com.trsvax.hotelbooking.pages.hotel;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.trsvax.hotelbooking.entities.Hotel;
import com.trsvax.hotelbooking.services.DAOsImple;

public class HotelIndexTest {

	@Test
	public void setupRender() {
		HotelIndex index = new HotelIndex();
		index.dao = new DAOsImple(new Hotel());	
		assertTrue(index.getHotels().size() == 1);
		assertTrue(index.hotel == null);
	}

}

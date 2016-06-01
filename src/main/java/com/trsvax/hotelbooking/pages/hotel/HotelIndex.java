package com.trsvax.hotelbooking.pages.hotel;

import java.util.List;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

import com.trsvax.hotelbooking.entities.Hotel;
import com.trsvax.hotelbooking.services.DAO;

public class HotelIndex {	
	@Inject
	DAO dao;
	
	@Property
	Hotel hotel;
	
	public List<Hotel> getHotels() {
		return dao.query(Hotel.class," from Hotel ");
	}

}

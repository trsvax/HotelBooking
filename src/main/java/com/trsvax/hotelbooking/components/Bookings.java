package com.trsvax.hotelbooking.components;

import java.text.Format;
import java.text.MessageFormat;
import java.util.List;

import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SetupRender;
import org.apache.tapestry5.annotations.SupportsInformalParameters;
import org.apache.tapestry5.corelib.components.Grid;
import org.apache.tapestry5.corelib.components.Output;
import org.apache.tapestry5.ioc.annotations.Inject;

import com.trsvax.hotelbooking.entities.Booking;
import com.trsvax.hotelbooking.entities.User;
import com.trsvax.hotelbooking.services.DAO;
import com.trsvax.hotelbooking.services.UserService;

@SupportsInformalParameters
public class Bookings {
	
	@Inject
	@Property
	UserService userService;
	
	@Parameter("userService.currentUser")
	User user;
	
	@Parameter(name="title",defaultPrefix="literal")
	String titleString;
	
	@Property
	List<Booking> bookings;
	
	@Component(parameters={"value=prop:value","format=prop:format"})
	Output title;
	
	@Component(parameters={"source=prop:bookings"},publishParameters="rowsPerPage,add,row",id="bookings",inheritInformalParameters=true)
	Grid bookingGrid;
	
	@Inject
	DAO dao;
		
	@SetupRender
	void setupRender() {
		bookings = dao.query(Booking.class, " from Booking where user = :user", "user",user);
	}
	
	public Format getFormat() {
		return new MessageFormat("{0}");
	}
		
	public Object[] getValue() {
		Object[] values = new Object[1];
		values[0] = titleString;
		return values;
	}
	

}

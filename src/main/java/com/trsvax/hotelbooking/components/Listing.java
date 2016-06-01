package com.trsvax.hotelbooking.components;

import java.text.Format;
import java.text.MessageFormat;

import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SupportsInformalParameters;
import org.apache.tapestry5.corelib.components.Grid;
import org.apache.tapestry5.corelib.components.Output;

import com.trsvax.hotelbooking.entities.User;

@SupportsInformalParameters
public class Listing implements com.trsvax.hotelbooking.Listing {
	
	@Parameter
	User user;
	
	@Parameter(name="title",defaultPrefix="literal")
	String titleString;
	
	@Property
	Object listings;
	
	@Component(parameters={"value=prop:value","format=prop:format"})
	Output title;
	
	@Component(parameters={"source=prop:bookings"},publishParameters="rowsPerPage,add,row",id="bookings",inheritInformalParameters=true)
	Grid bookingGrid;
	

	public Format getFormat() {
		return new MessageFormat("{0}");
	}
		
	public Object[] getValue() {
		Object[] values = new Object[1];
		values[0] = titleString;
		return values;
	}

	@Override
	public void setListing(Object listings) {
		this.listings = listings;
	}

}

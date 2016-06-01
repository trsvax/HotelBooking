package com.trsvax.hotelbooking.services;

import java.util.Date;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.tapestry5.services.ComponentSource;

import com.trsvax.hotelbooking.entities.Booking;
import com.trsvax.hotelbooking.entities.User;
import com.trsvax.hotelbooking.pages.email.BookingEmail;

public class HotelServiceImpl implements HotelService {
	
	private final UserService userService;
	private final DAO dao;
	private final EmailService emailService;
	private final ComponentSource componentSource;
	
	public HotelServiceImpl(UserService userService, DAO dao, EmailService emailService, ComponentSource componentSource) {
		this.userService = userService;
		this.dao = dao;
		this.emailService = emailService;
		this.componentSource = componentSource;
	}

	@Override
	@RequiresRoles("user")
	public String newBooking(Booking booking) {
		User user = userService.getCurrentUser();
		
		booking.bookingDate = new Date();
		booking.user = user;
		
		dao.save(booking);
		emailService.sendEmail(user.email, "HotelBooking", 
				String.format("%s Booking",booking.hotel.name), 
				String.format("You've booked %s hotel! Checkin date %s ", booking.hotel.name, booking.checkinDate));
		return "Confirmed";
	}
	
	public void sendEmail(Booking booking) {
		BookingEmail page = (BookingEmail) componentSource.getPage(BookingEmail.class);
		String body = page.body(booking);
	}

}

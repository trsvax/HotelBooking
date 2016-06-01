package com.trsvax.hotelbooking.services;

public interface EmailService {

	public void sendEmail(String to, String from, String subject, String body);
}

package com.trsvax.hotelbooking.services;

import org.slf4j.Logger;

public class SendEmailLogger implements EmailService {
	
	private final Logger logger;
	
	public SendEmailLogger(Logger logger) {
		this.logger = logger;
	}

	@Override
	public void sendEmail(String to, String from, String subject, String body) {
		logger.info("to: {} subject {}",to,subject);
		logger.info(body);
		
	}

}

package com.trsvax.hotelbooking.pages.jobs;

import org.apache.tapestry5.ioc.annotations.Inject;
import org.slf4j.Logger;

import com.trsvax.jacquard.Schedule;
import com.trsvax.jacquard.services.PageService;

@Schedule("0 * * ? * *")
public class GuestToday implements Runnable {
	
	@Inject
	PageService pageService;
	
	@Inject
	Logger logger;
	
	Object onActivate() {
		return pageService.runJob(this);
	}

	@Override
	public void run() {
		logger.info("running job");

		throw new RuntimeException("Not implemented");
	}
	
	

}

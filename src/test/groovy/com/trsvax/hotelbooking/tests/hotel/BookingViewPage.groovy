package com.trsvax.hotelbooking.tests.hotel

import geb.Page

class BookingViewPage extends Page {
	
	//static url = "hotel/booking/new/1";
	static at = { heading == "View" };
	
	static content = {
		heading { $("h1").text() }
		
	}

}

package com.trsvax.hotelbooking.tests.hotel

import geb.Page

class BookingNewPage extends Page {
	
	//static url = "hotel/booking/new/1";
	static at = { heading == "Book" };
	
	static content = {
		heading { $("h1").text() }
		
		checkinDate { $("#checkinDate") }
		
		checkoutDate { $("#checkoutDate") }
		
		beds { $("#beds") }
		
		bookButton { $("input[type='submit']") }
	}

}

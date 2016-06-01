package com.trsvax.hotelbooking.tests.hotel

import geb.Page

class HotelIndexPage extends Page {
	static url = "hotel";
	//static at = { title == "Hotels" };
	
	static content = {
		heading { $("h1").text() }
		book { $("a", text: "Book") }
	}

}

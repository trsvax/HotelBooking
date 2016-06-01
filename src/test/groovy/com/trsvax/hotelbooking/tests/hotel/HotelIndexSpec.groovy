package com.trsvax.hotelbooking.tests.hotel

import geb.spock.GebReportingSpec

import org.apache.tapestry5.test.Jetty7Runner

import spock.lang.Shared

class HotelIndexSpec extends GebReportingSpec {
	
	@Shared
	def runner;

	def setupSpec() {
			runner = new Jetty7Runner("src/main/webapp", "/hotel", 8080, 8081);
			runner.start()
	}

	def cleanupSpec() {
			runner.stop()
	}
	
	def "Hotel Index"() {
		when: to HotelIndexPage;
			book.click()
			
			
		and: 
			page(LoginPage)
			username.value("bfb")
			password.value("bfb")
			loginButton.click()
			
		
			page(BookingNewPage)
			checkinDate.value("01/01/2020")
			checkoutDate.value("01/02/2020")
			beds.value("1");
			bookButton.click()
			page(BookingViewPage)
			
		then:
			heading == "View"
			
			
	}
	
	

}

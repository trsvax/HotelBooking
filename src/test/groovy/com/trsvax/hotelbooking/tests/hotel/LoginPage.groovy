package com.trsvax.hotelbooking.tests.hotel

import geb.Page

class LoginPage extends Page {
	static url = "security/login/unauthenticated";
	
	static content = {
		username { $("#tynamoLogin") }
		password { $("#tynamoPassword") }
		loginButton { $("#tynamoEnter") };
	}

}

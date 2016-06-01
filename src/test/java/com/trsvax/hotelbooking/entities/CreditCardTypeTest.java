package com.trsvax.hotelbooking.entities;

import static org.junit.Assert.*;

import org.junit.Test;

public class CreditCardTypeTest {

	@Test
	public void test() {
		CreditCardType type = CreditCardType.valueOf("VISA");
		assertTrue( type == CreditCardType.VISA);
	}

}

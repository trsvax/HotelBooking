package com.trsvax.hotelbooking.entities;

import static org.junit.Assert.*;

import org.junit.Test;

public class PermissionTest {

	@Test
	public void testEquals() {
		Permission admin = new Permission();
		admin.permission = "admin";
		assertTrue( admin.equals("admin") );
	}
	
	@Test
	public void testToString() {
		Permission admin = new Permission();
		admin.permission = "admin";
		assertTrue( admin.toString().equals("admin"));
	}
	
	@Test
	public void testHashCode() {
		Permission admin = new Permission();
		admin.permission = "admin";
		assertTrue( admin.hashCode() == "admin".hashCode());
	}

}

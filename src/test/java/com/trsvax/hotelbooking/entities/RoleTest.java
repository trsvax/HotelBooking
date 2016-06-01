package com.trsvax.hotelbooking.entities;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.trsvax.hotelbooking.entities.Role;

public class RoleTest {

	@Test
	public void test() {
		Role admin = new Role();
		admin.role = "admin";
		assertTrue( admin.equals("admin") );
	}
	
	@Test
	public void test2() {
		Role admin = new Role();
		admin.role = "admin";
		assertTrue( admin.toString().equals("admin"));
	}

}

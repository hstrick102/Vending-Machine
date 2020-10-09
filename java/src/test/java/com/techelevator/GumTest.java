package com.techelevator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GumTest {
	Gum testGum = new Gum("D1","Orbit",.75,5);
	@Test
	public void get_price_return_75() {
		assertEquals(.75, testGum.getPrice(),.001);
	}
	
	@Test
	public void get_correct_candy_from_identifier() {
		assertEquals("Orbit",testGum.getName());
		
	}
	@Test
	public void get_correct_identifier() {
		assertEquals("D1",testGum.getIdentifier());
	}
	@Test
	public void get_correct_sound() {
		assertEquals("Chew Chew, Yum!",testGum.getSound());
	}
	
	@Test
	public void set_quantity_2 () {
		testGum.setQuantity(2);
		assertEquals(2,testGum.getQuantity());
	}

}

package com.techelevator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GumTest {
	Gum testGum = new Gum();
	@Test
	public void get_price_return_75() {
		assertEquals(.75, testGum.getPrice(),.001);
	}
	@Test
	public void get_correct_gum_from_identifier() {
		assertEquals("Orbit",testGum.getNameOfGum("D1"));
		assertEquals("Extra",testGum.getNameOfGum("D2"));
		assertEquals("Trident",testGum.getNameOfGum("D3"));
	}
	
	@Test
	public void quanity_5_take_3_remaing_quantity_2 () {
		testGum.setQuantity(5);
		assertEquals(2,testGum.getRemainingQuantity(3, "D1"));
		assertEquals(2,testGum.getRemainingQuantity(3, "D2"));
		assertEquals(2,testGum.getRemainingQuantity(3, "D3"));
	}
	
	@Test
	public void return_quantity() {
		testGum.setQuantity(3);
		assertEquals(3,testGum.getAvailableQuantity("D1"));
		assertEquals(3,testGum.getAvailableQuantity("D2"));
		assertEquals(3,testGum.getAvailableQuantity("D3"));
	}

}

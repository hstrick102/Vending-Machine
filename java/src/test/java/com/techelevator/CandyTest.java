package com.techelevator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CandyTest {
	Candy testCandy = new Candy();
	@Test
	public void get_price_return_150() {
		assertEquals(1.5, testCandy.getPrice(),.001);
	}
	@Test
	public void get_correct_candy_from_identifier() {
		assertEquals("Reeses",testCandy.getNameOfCandy("B1"));
		assertEquals("Snickers",testCandy.getNameOfCandy("B2"));
		assertEquals("Starburst",testCandy.getNameOfCandy("B3"));
	}
	
	@Test
	public void quanity_5_take_3_remaing_quantity_2 () {
		testCandy.setQuantity(5);
		assertEquals(2,testCandy.getRemainingQuantity(3, "B1"));
		assertEquals(2,testCandy.getRemainingQuantity(3, "B2"));
		assertEquals(2,testCandy.getRemainingQuantity(3, "B3"));
	}
	
	@Test
	public void return_quantity() {
		testCandy.setQuantity(3);
		assertEquals(3,testCandy.getAvailableQuantity("B1"));
		assertEquals(3,testCandy.getAvailableQuantity("B2"));
		assertEquals(3,testCandy.getAvailableQuantity("B3"));
	}

}

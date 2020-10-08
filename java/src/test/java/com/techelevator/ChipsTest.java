package com.techelevator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ChipsTest {
	Chips testChips = new Chips();
	@Test
	public void get_price_return_175() {
		assertEquals(1.75, testChips.getPrice(),.001);
	}
	@Test
	public void get_correct_chips_from_identifier() {
		assertEquals("Doritos",testChips.getNameOfChips("C1"));
		assertEquals("Lays",testChips.getNameOfChips("C2"));
		assertEquals("Utz",testChips.getNameOfChips("C3"));
	}
	
	@Test
	public void quanity_5_take_3_remaing_quantity_2 () {
		testChips.setQuantity(5);
		assertEquals(2,testChips.getRemainingQuantity(3, "C1"));
		assertEquals(2,testChips.getRemainingQuantity(3, "C2"));
		assertEquals(2,testChips.getRemainingQuantity(3, "C3"));
	}
	
	@Test
	public void return_quantity() {
		testChips.setQuantity(3);
		assertEquals(3,testChips.getAvailableQuantity("C1"));
		assertEquals(3,testChips.getAvailableQuantity("C2"));
		assertEquals(3,testChips.getAvailableQuantity("C3"));
	}

}

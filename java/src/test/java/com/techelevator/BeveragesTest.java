package com.techelevator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class BeveragesTest {
	Beverages beverage = new Beverages();
	@Test
	public void get_price_return_2() {
		assertEquals(2.0, beverage.getPrice(),0);
	}
	@Test
	public void get_correct_beverage_from_identifier() {
		assertEquals("Coke",beverage.getNameOfBeverage("A1"));
		assertEquals("Sprite",beverage.getNameOfBeverage("A2"));
		assertEquals("Water",beverage.getNameOfBeverage("A3"));
	}
	
	@Test
	public void quanity_5_take_3_remaing_quantity_2 () {
		beverage.setQuantity(5);
		assertEquals(2,beverage.getRemainingQuantity(3, "A1"));
		assertEquals(2,beverage.getRemainingQuantity(3, "A2"));
		assertEquals(2,beverage.getRemainingQuantity(3, "A3"));
	}
	
	@Test
	public void return_quantity() {
		beverage.setQuantity(3);
		assertEquals(3,beverage.getAvailableQuantity("A1"));
		assertEquals(3,beverage.getAvailableQuantity("A2"));
		assertEquals(3,beverage.getAvailableQuantity("A3"));
	}
	
}

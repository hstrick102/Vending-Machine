package com.techelevator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class BeveragesTest {
	Beverages beverage = new Beverages("A1","Coke",1.75,5);
	@Test
	public void get_price_return_175() {
		assertEquals(1.75, beverage.getPrice(),0);
	}
	@Test
	public void get_correct_beverage_from_identifier() {
		assertEquals("Coke",beverage.getName());
//		assertEquals("Sprite",beverage.getNameOfBeverage("A2"));
//		assertEquals("Water",beverage.getNameOfBeverage("A3"));
	}
	@Test
	public void get_correct_identifier() {
		assertEquals("A1",beverage.getIdentifier());
	}
	@Test
	public void get_correct_sound() {
		assertEquals("Glug Glug, Yum!",beverage.getSound());
	}
	
	@Test
	public void quanity_5_take_3_remaing_quantity_2 () {
		beverage.setQuantity(2);
		assertEquals(2,beverage.getQuantity());
//		assertEquals(2,beverage.getRemainingQuantity(3, "A2"));
//		assertEquals(2,beverage.getRemainingQuantity(3, "A3"));
	}
	
//	@Test
//	public void return_quantity() {
//		beverage.setQuantity(3);
//		assertEquals(3,beverage.getAvailableQuantity("A1"));
//		assertEquals(3,beverage.getAvailableQuantity("A2"));
//		assertEquals(3,beverage.getAvailableQuantity("A3"));
//	}
	
}

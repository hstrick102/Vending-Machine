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
	public void set_quantity_2 () {
		beverage.setQuantity(2);
		assertEquals(2,beverage.getQuantity());
	}
	
}

package com.techelevator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CandyTest {
	Candy testCandy = new Candy("B1","Snickers",1.75,5);
	@Test
	public void get_price_return_150() {
		assertEquals(1.75, testCandy.getPrice(),.001);
	}
	@Test
	public void get_correct_candy_from_identifier() {
		assertEquals("Snickers",testCandy.getName());
		
	}
	@Test
	public void get_correct_identifier() {
		assertEquals("B1",testCandy.getIdentifier());
	}
	@Test
	public void get_correct_sound() {
		assertEquals("Munch Munch, Yum!",testCandy.getSound());
	}
	
	@Test
	public void quanity_5_take_3_remaing_quantity_2 () {
		testCandy.setQuantity(2);
		assertEquals(2,testCandy.getQuantity());
	}
	
//	@Test
//	public void return_quantity() {
//		testCandy.setQuantity(3);
//		assertEquals(3,testCandy.getAvailableQuantity("B1"));
//		assertEquals(3,testCandy.getAvailableQuantity("B2"));
//		assertEquals(3,testCandy.getAvailableQuantity("B3"));
//	}

}

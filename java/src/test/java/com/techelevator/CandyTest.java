package com.techelevator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CandyTest {
	Candy testCandy = new Candy("B1","Snickers",1.75,5);
	@Test
	public void get_price_return_175() {
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
	public void set_quantity_2 () {
		testCandy.setQuantity(2);
		assertEquals(2,testCandy.getQuantity());
	}
	


}

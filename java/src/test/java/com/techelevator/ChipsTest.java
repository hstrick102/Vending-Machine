package com.techelevator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ChipsTest {
	Chips testChips = new Chips("C1","Doritos",1.75,5);
	@Test
	public void get_price_return_175() {
		assertEquals(1.75, testChips.getPrice(),.001);
	}
	@Test
	public void get_correct_chips_from_identifier() {
		assertEquals("Doritos",testChips.getName());
		
	}
	
	@Test
	public void get_correct_identifier() {
		assertEquals("C1",testChips.getIdentifier());
	}
	@Test
	public void get_correct_sound() {
		assertEquals("Crunch Crunch, Yum!",testChips.getSound());
	}
	
	@Test
	public void set_quantity_2 () {
		testChips.setQuantity(2);
		assertEquals(2,testChips.getQuantity());
	}

}

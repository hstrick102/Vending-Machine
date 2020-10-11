package com.techelevator;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ChipsTest {
	Chips testChips = new Chips("C1","Doritos",175,5);
	@Test
	public void get_price_return_175() {
		assertEquals(175, testChips.getPrice(),.001);
	}
	@Test
	public void get_correct_chips_name() {
		assertEquals("Doritos",testChips.getName());
		
	}
	@Test
	public void get_quantiy_5() {
		assertEquals(5,testChips.getQuantity());
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
	@Test
	public void return_toString() {
		String expected = "C1|Doritos|1.75|5";
		assertEquals(expected,testChips.toString());
	}
	@Test 
	public void reduce_quanity_by_1() {
		testChips.reduceQuantity();
		assertThat(testChips.getQuantity(), is(4));
	}
	@Test
	public void drink_is_sold_out() {
		testChips.setQuantity(0);
		String expected = "C1|Doritos|1.75|SOLD OUT";
		assertEquals(expected, testChips.toString());
	}
}

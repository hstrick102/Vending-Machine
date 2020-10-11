package com.techelevator;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class BeveragesTest {
	Beverages beverage = new Beverages("A1","Coke",175,5);
	@Test
	public void get_price_return_175() {
		assertEquals(175, beverage.getPrice(),0);
	}
	@Test
	public void get_correct_beverage_name() {
		assertEquals("Coke",beverage.getName());

	}
	@Test
	public void get_quantiy_5() {
		assertEquals(5,beverage.getQuantity());
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
	@Test
	public void return_toString() {
		String expected = "A1|Coke|1.75|5";
		assertEquals(expected,beverage.toString());
	}
	@Test 
	public void reduce_quanity_by_1() {
		beverage.reduceQuantity();
		assertThat(beverage.getQuantity(), is(4));
	}
	@Test
	public void drink_is_sold_out() {
		beverage.setQuantity(0);
		String expected = "A1|Coke|1.75|SOLD OUT";
		assertEquals(expected, beverage.toString());
	}
	
}

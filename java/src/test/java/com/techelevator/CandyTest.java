package com.techelevator;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class CandyTest {
	Candy testCandy = new Candy("B1","Snickers",175,5);
	@Test
	public void get_price_return_175() {
		assertEquals(175, testCandy.getPrice(),0);
	}
	@Test
	public void get_correct_candy_name() {
		assertEquals("Snickers",testCandy.getName());
		
	}
	@Test
	public void get_quantiy_5() {
		assertEquals(5,testCandy.getQuantity());
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
	
	@Test
	public void return_toString() {
		String expected = "B1|Snickers|1.75|5";
		assertEquals(expected,testCandy.toString());
	}
	@Test 
	public void reduce_quanity_by_1() {
		testCandy.reduceQuantity();
		assertThat(testCandy.getQuantity(), is(4));
	}
	@Test
	public void drink_is_sold_out() {
		testCandy.setQuantity(0);
		String expected = "B1|Snickers|1.75|SOLD OUT";
		assertEquals(expected, testCandy.toString());
	}

}

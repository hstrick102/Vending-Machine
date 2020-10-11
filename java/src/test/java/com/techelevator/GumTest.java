package com.techelevator;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class GumTest {
	Gum testGum = new Gum("D1","Orbit",75,5);
	@Test
	public void get_price_return_75() {
		assertEquals(75, testGum.getPrice(),0);
	}
	
	@Test
	public void get_correct_gum_name() {
		assertEquals("Orbit",testGum.getName());	
	}
	@Test
	public void get_quantiy_5() {
		assertEquals(5,testGum.getQuantity());
	}
	@Test
	public void get_correct_identifier() {
		assertEquals("D1",testGum.getIdentifier());
	}
	@Test
	public void get_correct_sound() {
		assertEquals("Chew Chew, Yum!",testGum.getSound());
	}
	
	@Test
	public void set_quantity_2 () {
		testGum.setQuantity(2);
		assertEquals(2,testGum.getQuantity());
	}
	@Test
	public void return_toString() {
		String expected = "D1|Orbit|0.75|5";
		assertEquals(expected,testGum.toString());
	}
	@Test 
	public void reduce_quanity_by_1() {
		testGum.reduceQuantity();
		assertThat(testGum.getQuantity(), is(4));
	}
	@Test
	public void drink_is_sold_out() {
		testGum.setQuantity(0);
		String expected = "D1|Orbit|0.75|SOLD OUT";
		assertEquals(expected, testGum.toString());
	}
	
}

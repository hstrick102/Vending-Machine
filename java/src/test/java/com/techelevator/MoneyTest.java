package com.techelevator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MoneyTest {
	Money money = new Money();
	@Test
	public void input_150_output_in_dollar_format() {
		assertEquals("1.50",money.moneyFormatter(150));
	}
	@Test
	public void input_205_output_change_coins() {
		String expected = "Your Change Contains: 8.0 quarter(s), 0.0 dime(s), 1.0 nickel(s), 0.0 pennies.";
		assertEquals(expected,money.makeChange(205));
	}
	@Test
	public void input_210_output_change_coins() {
		String expected = "Your Change Contains: 8.0 quarter(s), 1.0 dime(s), 0.0 nickel(s), 0.0 pennies.";
		assertEquals(expected,money.makeChange(210));
	}
	@Test
	public void input_211_output_change_coins() {
		String expected = "Your Change Contains: 8.0 quarter(s), 1.0 dime(s), 0.0 nickel(s), 1.0 pennies.";
		assertEquals(expected,money.makeChange(211));
	}
}

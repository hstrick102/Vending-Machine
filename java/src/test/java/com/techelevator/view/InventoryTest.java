package com.techelevator.view;


import static org.junit.Assert.assertEquals;


import java.util.Map;

import org.junit.Test;

import com.techelevator.Beverages;
import com.techelevator.Candy;
import com.techelevator.Chips;
import com.techelevator.Gum;
import com.techelevator.Items;

public class InventoryTest {
	
	Inventory stock = new Inventory();
	Map<String,Items> inventory = stock.inputStock();
	
 
	@Test
	public void test_if_Items_are_in_map() {
		assertEquals("Cowtales", inventory.get("B2").getName());
		assertEquals("Cloud Popcorn", inventory.get("A4").getName());
		assertEquals("U-Chews", inventory.get("D1").getName());
		assertEquals("Cola", inventory.get("C1").getName());
	}

}

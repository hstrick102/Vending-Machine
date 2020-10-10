package com.techelevator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.techelevator.view.Menu;

public class VendingMachineTest {
	
	Menu menu = new Menu(System.in, System.out);
	VendingMachineCLI test = new VendingMachineCLI(menu);
		
	
	@Test
	public void user_adds_five_dollars() {
		
//		VendingMachineCLI.feedMoney(1, 100.00);
//		assertEquals(100.00, VendingMachineCLI.feedMoney(1, 100.00), .001);
//		String choice = "$5";
//		
//		assertEquals(500, VendingMachineCLI.feedMoney(), .001);
	}
	
	
	@Test
	public void check_inventory_method() {
		VendingMachineCLI.inventory();
		String actual = VendingMachineCLI.allCandy.get("B1").toString();
		String expected = "B1|Moonpie|1.8|5";
		assertEquals(expected, actual);
		}


}

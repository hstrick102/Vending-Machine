package com.techelevator;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import com.techelevator.view.Menu;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE };

	private Menu menu;
	Beverages beverage = new Beverages();
	Chips chip = new Chips();
	Candy candies = new Candy();
	Gum gums = new Gum();

	public VendingMachineCLI(Menu menu) { 
		this.menu = menu;
	}

	public void run() {
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items
				
				for(Map.Entry<String, String> bev: beverage.allBeverages.entrySet()) {
					if(beverage.getAvailableQuantity(bev.getKey()) == 0) {
						 System.out.println(bev.getKey() + ": " + bev.getValue() + " | " + beverage.getPrice() + " | " + "SOLD OUT" );
					}else {
					 System.out.println(bev.getKey() + ": " + bev.getValue() + " | " + beverage.getPrice() + " | " + beverage.getAvailableQuantity(bev.getKey()) );
					}
				}
				for(Map.Entry<String, String> chips: chip.allChips.entrySet()) {
					if(chip.getAvailableQuantity(chips.getKey()) ==0) {
						System.out.println(chips.getKey() + ": " + chips.getValue() + " | " + chip.getPrice()+ " | " + "SOLD OUT");
					}else {
					 System.out.println(chips.getKey() + ": " + chips.getValue() + " | " + chip.getPrice()+ " | " + chip.getAvailableQuantity(chips.getKey()));
					}
				}
				for(Map.Entry<String, String> candy: candies.allCandy.entrySet()) {
					if(candies.getAvailableQuantity(candy.getKey()) == 0) {
						System.out.println(candy.getKey() + ": " + candy.getValue()+ " | " + candies.getPrice() + " | " + "SOLD OUT");
					}else {
					 System.out.println(candy.getKey() + ": " + candy.getValue()+ " | " + candies.getPrice() + " | " + candies.getAvailableQuantity(candy.getKey()));
					}
				}
				for(Map.Entry<String, String> gum: gums.allGum.entrySet()) {
					if(gums.getAvailableQuantity(gum.getKey())==0) {
						System.out.println(gum.getKey() + ": " + gum.getValue()+ " | " + gums.getPrice()+ " | " + "SOLD OUT");
					}else
					 System.out.println(gum.getKey() + ": " + gum.getValue()+ " | " + gums.getPrice()+ " | " + gums.getAvailableQuantity(gum.getKey()));
					}
			}
			else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// do purchase
			}
		}
	}
	

	
	//method to check if qty wanted is greater than qty aviabale

	public static void main(String[] args) throws IOException {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
		
		
//		//create new file 
//			File newFile = new File("input.txt");
//			newFile.createNewFile();
//				//check file has been created or exists
//			if(!newFile.exists()) {
//				System.out.println("Error - File not created");
//			}
//			
//			//Writing to newFile
//			try(PrintWriter writer = new PrintWriter(newFile.getAbsoluteFile())) {
//				writer.println("Hello World");
//			}
	}
}

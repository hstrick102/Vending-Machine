package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.techelevator.view.Menu;

public class VendingMachineCLI {
	
	//Main Menu
	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE };
	
	//Purchase Menu Variables
	private static final String PURCHASE_MENU_FEED_MONEY_OPTION = "Feed Money";
	private static final String PURCHASE_MENU_SELECT_PRODUCT_OPTION = "Select Product";
	private static final String PURCHASE_MENU_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_FEED_MONEY_OPTION, PURCHASE_MENU_SELECT_PRODUCT_OPTION, PURCHASE_MENU_FINISH_TRANSACTION};

	private Menu menu;
	static Beverages beverage = new Beverages();
	static Chips chip = new Chips();
	static Candy candies = new Candy();
	static Gum gums = new Gum();

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
			} else {
				// exit ?
			}
		}
	}
	
	
	//Purchase Method
	public static void purchase() {
		String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
		
	}
	
	
	//Inventory Method
	public static void inventory() {
		File inventoryFile = new File("input.txt");
		Map <String, Integer> allLines = new HashMap<>();
		try(Scanner inventoryScanner = new Scanner(inventoryFile)) {
			while(inventoryScanner.hasNextLine()) {
				String line = inventoryScanner.nextLine();
				if(line.contains("|")) {
					allLines.put(line.substring(0, 2), Integer.parseInt(line.substring(3)));
				}
				for(Map.Entry<String, Integer> inventory : allLines.entrySet()) {
					if(inventory.getKey().equals("A1") || inventory.getKey().equals("A2") || inventory.getKey().equals("A3")) {
						
						beverage.setQuantity(inventory.getValue());
					}
					if(inventory.getKey().equals("B1") || inventory.getKey().equals("B2") || inventory.getKey().equals("B3")) {
						
						candies.setQuantity(inventory.getValue());
					}
					if(inventory.getKey().equals("C1") || inventory.getKey().equals("C2") || inventory.getKey().equals("C3")) {
						
						chip.setQuantity(inventory.getValue());
					}
					if(inventory.getKey().equals("D1") || inventory.getKey().equals("D2") || inventory.getKey().equals("D3")) {
						
						gums.setQuantity(inventory.getValue());
					}
					
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("File does not exist");
		}
		
	}
	
	
	
	//method to check if qty wanted is greater than qty aviabale

	public static void main(String[] args) throws IOException {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		inventory();
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

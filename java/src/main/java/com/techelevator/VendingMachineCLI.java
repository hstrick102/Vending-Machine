package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Scanner;

import com.techelevator.view.Menu;


public class VendingMachineCLI {
	 
	//Main Menu
	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE,MAIN_MENU_EXIT };
	
	//Purchase Menu Variables
	private static final String PURCHASE_MENU_FEED_MONEY_OPTION = "Feed Money";
	private static final String PURCHASE_MENU_SELECT_PRODUCT_OPTION = "Select Product";
	private static final String PURCHASE_MENU_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_FEED_MONEY_OPTION, PURCHASE_MENU_SELECT_PRODUCT_OPTION, PURCHASE_MENU_FINISH_TRANSACTION};

	private static Menu menu;
	
	static Beverages beverage = new Beverages();
	static Chips chip = new Chips();
	static Candy candies = new Candy();
	static Gum gums = new Gum();
	
	static double currentMoney = 0;
	
	public static Map<String,String> getAllItems(Beverages beverage, Chips chip, Candy candies, Gum gums){
		Map<String,String> allItems = new HashMap<>();
		for(Map.Entry<String, String> bev: beverage.allBeverages.entrySet()) {
			allItems.put(bev.getKey(), bev.getValue());
		}
		for(Map.Entry<String, String> chips: chip.allChips.entrySet()) {
			allItems.put(chips.getKey(), chips.getValue());
		}
		for(Map.Entry<String, String> candy: candies.allCandy.entrySet()) {
			allItems.put(candy.getKey(), candy.getValue());
		}
		for(Map.Entry<String, String> gum: gums.allGum.entrySet()) {
			allItems.put(gum.getKey(), gum.getValue());
		}
		return allItems;
	}
	

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
						 System.out.println(bev.getKey() + "|" + bev.getValue() + "|" + beverage.getPrice()/100.00D + "|" + "SOLD OUT" );
					}else {
					 System.out.println(bev.getKey() + "|" + bev.getValue() + "|" + beverage.getPrice()/100.00D + "|" + beverage.getAvailableQuantity(bev.getKey()) );
					}
				}
				for(Map.Entry<String, String> candy: candies.allCandy.entrySet()) {
					if(candies.getAvailableQuantity(candy.getKey()) == 0) {
						System.out.println(candy.getKey() + "|" + candy.getValue()+ "|" + candies.getPrice()/100.00D + "|" + "SOLD OUT");
					}else {
					 System.out.println(candy.getKey() + "|" + candy.getValue()+ "|" + candies.getPrice()/100.00D + "|" + candies.getAvailableQuantity(candy.getKey()));
					}
				}
				for(Map.Entry<String, String> chips: chip.allChips.entrySet()) {
					if(chip.getAvailableQuantity(chips.getKey()) ==0) {
						System.out.println(chips.getKey() + "|" + chips.getValue() + "|" + chip.getPrice()/100.00D+ "|" + "SOLD OUT");
					}else {
					 System.out.println(chips.getKey() + "|" + chips.getValue() + "|" + chip.getPrice()/100.00D+ "|" + chip.getAvailableQuantity(chips.getKey()));
					}
				}
				for(Map.Entry<String, String> gum: gums.allGum.entrySet()) {
					if(gums.getAvailableQuantity(gum.getKey())==0) {
						System.out.println(gum.getKey() + "|" + gum.getValue()+ "|" + gums.getPrice()/100.00D+ "|" + "SOLD OUT");
					}else
					 System.out.println(gum.getKey() + "|" + gum.getValue()+ "|" + gums.getPrice()/100.00D+ "|" + gums.getAvailableQuantity(gum.getKey()));
					}
			}
			else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// do purchase
				purchase();
			} else if(choice.equals(MAIN_MENU_EXIT)){
				System.exit(0);
				// exit ?
			}
		}
	}
	
	
	//Purchase Method
	public static void purchase() {
		Map <String,String> purchaseItems = getAllItems(beverage, chip, candies, gums);
		Scanner userInput = new Scanner(System.in);
		System.out.println();
		System.out.println("Current Money Provide: " + currentMoney);
		String choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
		
		
		if (choice.equals(PURCHASE_MENU_FEED_MONEY_OPTION)) {
			System.out.print("Insert Money(whole dollars only)>> ");
			//if statement to catch in user inputs money with change
			String moneyIn = userInput.nextLine();
			double moneyInDouble = Double.parseDouble(moneyIn) * 100.00D;
			currentMoney += moneyInDouble;
			choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
			
		}else if (choice.equals(PURCHASE_MENU_SELECT_PRODUCT_OPTION)) {
			//printing out all options
// 		Option 1:
//			Map<String,String> items = getAllItems(beverage, chip, candies, gums);
//			for(Map.Entry<String, String> item: items.entrySet()) {
//				System.out.println(item.getKey() + ": " + item.getValue());
//			}
//		Option 2:
			for(Map.Entry<String, String> bev: beverage.allBeverages.entrySet()) {
				 System.out.println(bev.getKey() + ": " + bev.getValue());
			}
			for(Map.Entry<String, String> candy: candies.allCandy.entrySet()) {
				 System.out.println(candy.getKey() + ": " + candy.getValue());
			}
			for(Map.Entry<String, String> chips: chip.allChips.entrySet()) {
				 System.out.println(chips.getKey() + ": " + chips.getValue());
			}
			for(Map.Entry<String, String> gum: gums.allGum.entrySet()) {
				 System.out.println(gum.getKey() + ": " + gum.getValue());
			}
			
			// user chooses 
			System.out.print("Please Chooses an option>> ");
			String identifier = userInput.nextLine();
			System.out.println();
			
				// check if valid
				if(purchaseItems.containsKey(identifier)) {
				for(Map.Entry<String, String> bev: beverage.allBeverages.entrySet()) {
					if (identifier.equals(bev.getKey())) {
						currentMoney = (currentMoney - beverage.getPrice())/ 100.0;
						System.out.println("Glug Glug, Yum!");
						System.out.println(bev.getValue() + " Price is: " + beverage.getPrice()/100.00D + " Money Remaining: " + currentMoney );
						choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
					}else if(beverage.getAvailableQuantity(bev.getKey()) == 0){
						System.out.println("This Item is out of stock! ");
						choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
						}
				}
				for(Map.Entry<String, String> chips: chip.allChips.entrySet()) {
					if (identifier.equals(chips.getKey())) {
						currentMoney = (currentMoney - chip.getPrice())/ 100.0;
						System.out.println("Crunch Crunch, Yum!");
						System.out.println(chips.getValue() + " Price is: " + chip.getPrice()/100.00D + " Money Remaining: " + currentMoney );
						choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
					}else if(chip.getAvailableQuantity(chips.getKey()) == 0){
						System.out.println("This Item is out of stock! ");
						choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
						}
				}
				for(Map.Entry<String, String> candy: candies.allCandy.entrySet()) {
					if (identifier.equals(candy.getKey())) {
						currentMoney = (currentMoney - candies.getPrice())/ 100.0;
						System.out.println("Munch Munch, Yum!");
						System.out.println(candy.getValue() + " Price is: " + candies.getPrice()/100.00D + " Money Remaining: " + currentMoney );
						choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
					}else if(candies.getAvailableQuantity(candy.getKey()) == 0){
						System.out.println("This Item is out of stock! ");
						choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
						}
				}
				for(Map.Entry<String, String> gum: gums.allGum.entrySet()) {
					if (identifier.equals(gum.getKey())) {
						currentMoney = (currentMoney - gums.getPrice())/ 100.0;
						System.out.println("Chew Chew, Yum!");
						System.out.println(gum.getValue() + " Price is: " + gums.getPrice()/100.00D + " Money Remaining: " + currentMoney );
						choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
					}else if(gums.getAvailableQuantity(gum.getKey()) == 0){
						System.out.println("This Item is out of stock! ");
						choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
						}
				}
					
				}
			else {
				System.out.println("NOT A VALID INPUT");
			}
		}else if (choice.equals(PURCHASE_MENU_FINISH_TRANSACTION)) {
			//get remaining money out
			choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
		}
		
	}
	
	
	//Inventory Method
	public static void inventory() {
		File inventoryFile = new File("input.txt");
		//File inventoryFile = new File("vendingmachine.csv");
		Map <String, Integer> allLines = new HashMap<>();
		//List<String> lines = new ArrayList<>():
		try(Scanner inventoryScanner = new Scanner(inventoryFile)) {
			while(inventoryScanner.hasNextLine()) {
				String line = inventoryScanner.nextLine();
				//list.add(line.substring(0,2);
				//for(int i = 3; i<line.length(); i++){
				//if(line.charAt(i)== ("|"){
				//list.add(line.substring(0,i);
				//}}
			//if(lines.contains("Drink")){
				//beverage.putBeverages(lines.get(0),lines.get(1));
				//beverage.setPrice(lines.get(2));
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

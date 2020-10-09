package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

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
	
	static Beverages beverage;
	static Chips chip; 
	static Candy candies;
	static Gum gums;
	static Map<String,Object> allItems = new HashMap<>();
	static Map<String,Beverages> allDrinks = new HashMap<>();
	static Map<String,Chips> allChips = new HashMap<>();
	static Map<String,Candy> allCandy = new HashMap<>();
	static Map<String,Gum> allGum = new HashMap<>();
	 
	static double currentMoney = 0;
	
//	public static Map<String,String> getAllItems(Beverages beverage, Chips chip, Candy candies, Gum gums){ 
//		
//		for(Map.Entry<String, String> bev: beverage.allBeverages.entrySet()) {
//			allItems.put(bev.getKey(), bev.getValue());
//		}
//		for(Map.Entry<String, String> chips: chip.allChips.entrySet()) {
//			allItems.put(chips.getKey(), chips.getValue());
//		}
//		for(Map.Entry<String, String> candy: candies.allCandy.entrySet()) {
//			allItems.put(candy.getKey(), candy.getValue());
//		}
//		for(Map.Entry<String, String> gum: gums.allGum.entrySet()) {
//			allItems.put(gum.getKey(), gum.getValue());
//		}
//		return allItems;
//	}
//	

	public VendingMachineCLI(Menu menu) { 
		this.menu = menu;
	}

	public void run() {
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			
		
			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items
			
				
				for(Map.Entry<String, Object> items: allItems.entrySet()) {
					
					if(items.getKey().contains("C")) {
						System.out.println(items.getValue().toString());
					}
					else if(items.getKey().contains("A")) {
						System.out.println(items.getValue().toString());
					}
					else if(items.getKey().contains("B")) {
						System.out.println(items.getValue().toString());
					}
					else if(items.getKey().contains("D")) {
						System.out.println(items.getValue().toString());
					}
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
		//Map <String,String> purchaseItems = getAllItems(beverage, chip, candies, gums);
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
			purchase();
			
		}else if (choice.equals(PURCHASE_MENU_SELECT_PRODUCT_OPTION)) {
			//printing out all options

			
			for(Map.Entry<String, Object> item: allItems.entrySet()) {
				System.out.println(item.getValue().toString());
			}
		
			// user chooses 
			System.out.print("Please Chooses an option>> ");
			String identifier = userInput.nextLine();
			System.out.println();
			
			// check if valid
			if(allItems.containsKey(identifier)) {
				
					if(identifier.contains("C")) {
						
						if(allDrinks.get(identifier).getQuantity() == 0) {
							System.out.println("This product is SOLD OUT!");
						}else {
							
							beverage.reduceQuantity();
							if(currentMoney - allDrinks.get(identifier).getPrice() < 0) {
								System.out.println("Not enough money, please feed more");
							}else {
								currentMoney -= allDrinks.get(identifier).getPrice();
								System.out.println(beverage.getSound());
							}
							
						}
						purchase();
					}
					else if(identifier.contains("A")) {
						
						if(allChips.get(identifier).getQuantity() == 0) {
							System.out.println("This product is SOLD OUT!");
						}else {
							
							chip.reduceQuantity();
							if(currentMoney - allChips.get(identifier).getPrice() < 0) {
								System.out.println("Not enough money, please feed more");
							}else {
								currentMoney -= allChips.get(identifier).getPrice();
								System.out.println(chip.getSound());
							}
						}
						purchase();
					}
					else if(identifier.contains("B")) {
						System.out.println(candies.getSound());
						if(allCandy.get(identifier).getQuantity() == 0) {
							System.out.println("This product is SOLD OUT!");
						}else {
							
							candies.reduceQuantity();
							if(currentMoney - allCandy.get(identifier).getPrice() < 0) {
								System.out.println("Not enough money, please feed more");
							}else {
								currentMoney -= allCandy.get(identifier).getPrice();
								System.out.println(candies.getSound());
							}
						}
						purchase();
						
					}
					else if(identifier.contains("D")) {
						System.out.println(gums.getSound());
						if(allGum.get(identifier).getQuantity() == 0) {
							System.out.println("This product is SOLD OUT!");
						}else {
							System.out.println(chip.getSound());
							gums.reduceQuantity();
							if(currentMoney - allGum.get(identifier).getPrice() < 0) {
								System.out.println("Not enough money, please feed more");
							}else {
							currentMoney -= allGum.get(identifier).getPrice();
							System.out.println(gums.getSound());
							}
						}
						purchase();
					}
				
			}
			else {
				System.out.println("NOT A VALID INPUT");
			}
		}else if (choice.equals(PURCHASE_MENU_FINISH_TRANSACTION)) {
			//get remaining money out
			double quarter = 25;
			double dime = 10;
			double nickel = 5;
			double penny = 1;
			int numberOfQuarters =0;
			int numberOfDimes = 0;
			int numberOfNickels = 0;
			int numberOfPennies = 0;
			while(currentMoney > 0) {
				if(numberOfQuarters ==0) {
				numberOfQuarters = (int) (currentMoney/quarter);
				currentMoney -= (quarter*numberOfQuarters);
				}
				else if(numberOfDimes == 0 ) {
				numberOfDimes = (int) (currentMoney/dime);
				currentMoney -= (dime* numberOfDimes);
				}
				else if(numberOfNickels == 0) {
					numberOfNickels = (int) (currentMoney/nickel);
					currentMoney -= (nickel* numberOfNickels);
				}
				else {
					numberOfPennies = (int) (currentMoney/penny);
					currentMoney -= (penny* numberOfPennies);
				}
				
			}
			System.out.println("Your Change Contains: " + numberOfQuarters+ " quarter(s), " + numberOfDimes+ " dime(s), " + numberOfNickels+ " nickel(s), " + numberOfPennies + " pennies." );
			choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
		}
		
	}
	
	
	//Inventory Method
	public static void inventory() {
		
		File inventoryFile = new File("vendingmachine.csv");
		
		
		try(Scanner inventoryScanner = new Scanner(inventoryFile)) {
			while(inventoryScanner.hasNextLine()) {
				String line = inventoryScanner.nextLine();
				String [] lines = line.split("\\|");
				
			if(lines[3].equals("Drink")){
				beverage = new Beverages(lines[0],lines[1],Double.parseDouble(lines[2])*100,5);
				allItems.put(lines[0],beverage);
				allDrinks.put(lines[0],beverage);
				
			}
			else if(lines[3].equals("Chip")){
				
				chip = new Chips(lines[0],lines[1],Double.parseDouble(lines[2])*100,5);
				allItems.put(lines[0],chip);
				allChips.put(lines[0],chip);
			}
			else if(lines[3].equals("Candy")){
				
				candies = new Candy(lines[0],lines[1],Double.parseDouble(lines[2])*100,5);
				allItems.put(lines[0],candies);
				allCandy.put(lines[0],candies);
			
			}
			else if(lines[3].equals("Gum")){
				
				gums = new Gum(lines[0],lines[1],Double.parseDouble(lines[2])*100,5);
				allItems.put(lines[0],gums);
				allGum.put(lines[0],gums);
			}
			}
		} catch (FileNotFoundException e) {
			System.out.println("File does not exist");
		}
		
	}
	
	//Feed money
	
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

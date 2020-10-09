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

import com.techelevator.view.LogWriter;
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
	
	
	//Feed menu variables
	private static final String CHOOSE_ONE = "$1";
	private static final String CHOOSE_TWO = "$2";
	private static final String CHOOSE_FIVE = "$5";
	private static final String CHOOSE_TEN = "$10";
	
	private static final String[] FEED_MENU_OPTIONS = {CHOOSE_ONE, CHOOSE_TWO, CHOOSE_FIVE, CHOOSE_TEN};

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
	
	static LogWriter informationLog = new LogWriter();
	 
	static double currentMoney = 0;
	
	

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
		System.out.println("Current Money Provide: $" + currentMoney/100);
		String choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
		
		
		if (choice.equals(PURCHASE_MENU_FEED_MONEY_OPTION)) {
			double moneyIn = feedMoney();
			currentMoney += moneyIn;
			informationLog.logger("Feed Money", moneyIn, currentMoney);
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
							
							if(currentMoney - allDrinks.get(identifier).getPrice() < 0) {
								System.out.println("Not enough money, please feed more");
							}else {
								allDrinks.get(identifier).reduceQuantity();
								informationLog.logger(allDrinks.get(identifier).getName() + " " + allDrinks.get(identifier).getIdentifier(), currentMoney, 
										currentMoney - allDrinks.get(identifier).getPrice());
								currentMoney -= allDrinks.get(identifier).getPrice();
								System.out.println(beverage.getSound());
								System.out.println(allDrinks.get(identifier).getName() + " Price: $" + allDrinks.get(identifier).getPrice()/100.0 + " Available Money: $" + currentMoney/100.0);
							}
							
						}
						purchase();
					}
					else if(identifier.contains("A")) {
						
						if(allChips.get(identifier).getQuantity() == 0) {
							System.out.println("This product is SOLD OUT!");
						}else {
							
							if(currentMoney - allChips.get(identifier).getPrice() < 0) {
								System.out.println("Not enough money, please feed more");
							}else {
								allChips.get(identifier).reduceQuantity();
								informationLog.logger(allChips.get(identifier).getName() + " " + allChips.get(identifier).getIdentifier(), currentMoney, 
										currentMoney - allChips.get(identifier).getPrice());
								currentMoney -= allChips.get(identifier).getPrice();
								System.out.println(chip.getSound());
								System.out.println(allChips.get(identifier).getName() + " Price: $" + allChips.get(identifier).getPrice()/100.0 + " Available Money: $" + currentMoney/100.0);
							}
						}
						purchase();
					}
					else if(identifier.contains("B")) {
						if(allCandy.get(identifier).getQuantity() == 0) {
							System.out.println("This product is SOLD OUT!");
						}else {
							
							if(currentMoney - allCandy.get(identifier).getPrice() < 0) {
								System.out.println("Not enough money, please feed more");
							}else {
								allCandy.get(identifier).reduceQuantity();
								informationLog.logger(allCandy.get(identifier).getName() + " " + allCandy.get(identifier).getIdentifier(), currentMoney, 
										currentMoney - allCandy.get(identifier).getPrice());
								currentMoney -= allCandy.get(identifier).getPrice();
								System.out.println(candies.getSound());
								System.out.println(allCandy.get(identifier).getName() + " Price: $" + allCandy.get(identifier).getPrice()/100.0 + " Available Money: $" + currentMoney/100.0);
								
							}
						}
						purchase();
						
					}
					else if(identifier.contains("D")) {
						
						if(allGum.get(identifier).getQuantity() == 0) {
							System.out.println("This product is SOLD OUT!");
						}else {
							
							if(currentMoney - allGum.get(identifier).getPrice() < 0) {
								System.out.println("Not enough money, please feed more");
							}else {
								allGum.get(identifier).reduceQuantity();
							informationLog.logger(allGum.get(identifier).getName() + " " + allGum.get(identifier).getIdentifier(), currentMoney, 
									currentMoney - allGum.get(identifier).getPrice());
							currentMoney -= allGum.get(identifier).getPrice();
							System.out.println(gums.getSound());
							System.out.println(allGum.get(identifier).getName() + " Price: $" + allGum.get(identifier).getPrice()/100.0 + " Available Money: $" + currentMoney/100.0);
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
			double numberOfQuarters =0;
			double numberOfDimes = 0;
			double numberOfNickels = 0;
			double numberOfPennies = 0;
			while(currentMoney > 0) {
				if(numberOfQuarters ==0) {
				numberOfQuarters = Math.floor(currentMoney/quarter);
				currentMoney -= (quarter*numberOfQuarters);
				}
				else if(numberOfDimes == 0 ) {
				numberOfDimes =  Math.floor(currentMoney/dime);
				currentMoney -= (dime* numberOfDimes);
				}
				else if(numberOfNickels == 0) {
					numberOfNickels =  Math.floor(currentMoney/nickel);
					currentMoney -= (nickel* numberOfNickels);
				}
				else {
					numberOfPennies =  Math.floor(currentMoney/penny);
					currentMoney -= (penny* numberOfPennies);
				}
				
			}
			System.out.println("Your Change Contains: " + numberOfQuarters+ " quarter(s), " + numberOfDimes+ " dime(s), " + numberOfNickels+ " nickel(s), " + numberOfPennies + " pennies." );
			
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
	public static double feedMoney() {
		
	
	//System.out.print("Insert Money(whole dollars only)>> ");
	double moneyIn = 0;
	String choice = (String) menu.getChoiceFromOptions(FEED_MENU_OPTIONS);
	//if statement to catch in user inputs money with change
	//String moneyIn = userInput.nextLine();
	if(choice.equals(CHOOSE_ONE)) {
		moneyIn = 100.00;
	} else if(choice.equals(CHOOSE_TWO)) {
		moneyIn = 200.00;
	} else if(choice.equals(CHOOSE_FIVE)) {
		moneyIn = 500.00;
	} else if(choice.equals(CHOOSE_TEN)) {
		moneyIn = 1000.00;
	} else {
		System.out.println("CANNOT ACCEPT");
	}
		return moneyIn;
	
	//double moneyInDouble = Double.parseDouble(moneyIn) * 100.00D;
}
	//method to check if qty wanted is greater than qty aviabale

	public static void main(String[] args) throws IOException {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		inventory();
		cli.run();
		
		
//		
	}
}

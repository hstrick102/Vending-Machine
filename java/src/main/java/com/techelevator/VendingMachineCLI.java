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

import com.techelevator.view.Inventory;
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
	
	static Money money = new Money();
	
	static Beverages beverage;
	static Chips chip; 
	static Candy candies; 
	static Gum gums;
	static Inventory inventory; 
	
	static Map<String,Items> allItems = inventory.inputStock();
	
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
			
				
				for(Entry<String, Items> items: allItems.entrySet()) {
					
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
				
			}
		}
	}
	
	
	//Purchase Method
	public static void purchase() {
		
		Scanner userInput = new Scanner(System.in);
		System.out.println();
		System.out.println("Current Money Provide: $" + money.moneyFormatter(currentMoney));
		String choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
		
		
		if (choice.equals(PURCHASE_MENU_FEED_MONEY_OPTION)) {
			double moneyIn = feedMoney();
			currentMoney += moneyIn;
			informationLog.logger("Feed Money", moneyIn, currentMoney);
			purchase();
			
		}else if (choice.equals(PURCHASE_MENU_SELECT_PRODUCT_OPTION)) {
			//printing out all options
			for(Entry<String, Items> item: allItems.entrySet()) {
				System.out.println(item.getValue().toString());
			}
		
			// user chooses 
			System.out.println();
			System.out.print("Please Chooses an option>> ");
			String identifier = userInput.nextLine();
			System.out.println();
			
			// check if valid
			if(allItems.containsKey(identifier)) {
						
				if(allItems.get(identifier).getQuantity() == 0) {
					System.out.println("This product is SOLD OUT!");
				}else {
					
					if(currentMoney - allItems.get(identifier).getPrice() < 0) {
						System.out.println("Not enough money, please feed more");
					}else {
						allItems.get(identifier).reduceQuantity();
						informationLog.logger(allItems.get(identifier).getName() + " " + allItems.get(identifier).getIdentifier(), currentMoney, 
								currentMoney - allItems.get(identifier).getPrice());
						currentMoney -= allItems.get(identifier).getPrice();
						System.out.println(allItems.get(identifier).getSound());
						System.out.println(allItems.get(identifier).getName() + " Price: $" + money.moneyFormatter(allItems.get(identifier).getPrice()) +
								" Available Money: $" + money.moneyFormatter(currentMoney));
					}
					
				}
				purchase();
			}
			else {
				System.out.println("NOT A VALID INPUT");
			}
		}else if (choice.equals(PURCHASE_MENU_FINISH_TRANSACTION)) {
			
			informationLog.logger("Give Change", currentMoney, Double.parseDouble(money.moneyFormatter(0.0)));
			System.out.println(money.makeChange(currentMoney));
		}
	}
	
	
	//Feed money
	public static double feedMoney() {
	
		double moneyIn = 0;
		String choice = (String) menu.getChoiceFromOptions(FEED_MENU_OPTIONS);
		//if statement to catch in user inputs money with change
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
		}
	

	public static void main(String[] args) throws IOException {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
		
	}
}

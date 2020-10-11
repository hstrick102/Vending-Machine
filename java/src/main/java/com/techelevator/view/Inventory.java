package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.techelevator.Beverages;
import com.techelevator.Candy;
import com.techelevator.Chips;
import com.techelevator.Gum;
import com.techelevator.Items;

public class Inventory {
	static Map<String,Items> allItems = new HashMap<>();
	static Beverages beverage;
	static Chips chip; 
	static Candy candies; 
	static Gum gums;
	//Inventory Method
		public static Map<String, Items> inputStock() {
			File inventoryFile = new File("vendingmachine.csv");

			try(Scanner inventoryScanner = new Scanner(inventoryFile)) {
				while(inventoryScanner.hasNextLine()) {
					String line = inventoryScanner.nextLine();
					String [] lines = line.split("\\|");
					
					if(lines[3].equals("Drink")){
						beverage = new Beverages(lines[0],lines[1],Double.parseDouble(lines[2])*100,5);
						allItems.put(lines[0],beverage);
						//allDrinks.put(lines[0],beverage); 
						
					}
					else if(lines[3].equals("Chip")){
						
						chip = new Chips(lines[0],lines[1],Double.parseDouble(lines[2])*100,5);
						allItems.put(lines[0],chip);
						//allChips.put(lines[0],chip);
						
					}
					else if(lines[3].equals("Candy")){ 
						
						candies = new Candy(lines[0],lines[1],Double.parseDouble(lines[2])*100,5);
						allItems.put(lines[0],candies);
						//allCandy.put(lines[0],candies);
					
					}
					else if(lines[3].equals("Gum")){
						
						gums = new Gum(lines[0],lines[1],Double.parseDouble(lines[2])*100,5);
						allItems.put(lines[0],gums);
						//allGum.put(lines[0],gums);
					}
				}
			} catch (FileNotFoundException e) {
				System.out.println("File does not exist");
			}
			return allItems;
		}
}

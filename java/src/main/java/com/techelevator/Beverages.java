package com.techelevator;

import java.util.HashMap;
import java.util.Map;

public class Beverages {
	Map<String,String> allBeverages = new HashMap<>(); 
	private static final double price = 200.0D;
	private int quantityCoke;
	private int quantitySprite;
	private int quantityWater;
	private String name;
	
	
	//CTOR 
	public Beverages() {
		putBeverages(name, name);
		
	}
	
		//getters
		
		public double getPrice() {
			return price ;
		}
		
		//derived methods
		public String getNameOfBeverage(String identifier) {
			return allBeverages.get(identifier);
		}
				
		
		public int getAvailableQuantity(String id) {
			  if(getNameOfBeverage(id).equals("Coke")) {
				  return quantityCoke;
			  } else if (getNameOfBeverage(id).equals("Sprite")) {
				  return quantitySprite;
			  } else {
				  return quantityWater;
			  }
			  
		  }
	  
	  public int getRemainingQuantity(int numberWanted, String id) {
		  int quantity = 0;
		  //check in qty wanted is greater than qty available
		  if(getNameOfBeverage(id).equals("Coke")) {
			  quantity = quantityCoke - numberWanted;
		  } else if (getNameOfBeverage(id).equals("Sprite")) {
			  quantity = quantitySprite - numberWanted;
		  } else {
			  quantity = quantityWater - numberWanted;
		  }
		  return quantity;
	  }
	  
	  public void setQuantity(int resetValues) {
		  this.quantityCoke = resetValues;
		  this.quantitySprite = resetValues;
		  this.quantityWater = resetValues;
	  }
	  
	 public void putBeverages(String identifier, String name) {
		 
		 allBeverages.put(identifier, this.name);
	 }

}

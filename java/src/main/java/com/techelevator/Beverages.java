package com.techelevator;

import java.util.HashMap;
import java.util.Map;

public class Beverages {
	Map<String,String> allBeverages = new HashMap<>();
	private static final int price = 200;
	private static int quantity;
	
	
	//CTOR
	public Beverages() {
		putBeverages();
		
	}
	
		//getters
		
		public double getPrice() {
			return (double)(price / 100);
		}
		
		//derived methods
		public String getNameOfBeverage(String identifier) {
			return allBeverages.get(identifier);
		}
				
		
	  public int getAvailableQuantity() {
		  return quantity;
	  }
	  
	  public int getRemainingQuantity(int numberWanted) {
		  quantity -= numberWanted;
		  return quantity;
	  }
	  
	  public void setQuantity(int resetValues) {
		  this.quantity = resetValues;
	  }
	  
	 public void putBeverages() {
		 allBeverages.put("A1", "Coke");
		 allBeverages.put("A2", "Sprite");
		 allBeverages.put("A3", "Water");
	 }

}

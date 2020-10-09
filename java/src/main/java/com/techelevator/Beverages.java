package com.techelevator;

import java.util.HashMap;
import java.util.Map;

public class Beverages {
	Map<String,Double> allBeverages = new HashMap<>(); 
	private double price;
	private String name;
	private int quantity;
	private String identifier;
	private String sound;
	
	
	//CTOR 
	public Beverages(String identifier, String name, double price, int quantity ) {
		this.identifier = identifier;
		this.name = name;
		this.sound = "Glug Glug, Yum!";
		this.price = price;
		this.quantity = quantity;
		
	}
	
		//getters
		
		public double getPrice() {
			return this.price ;
		}
		
		public String getName() {
			return this.name;
		}
		public int getQuantity() {
			return this.quantity;
		}
		public String getSound() {
			return "Glug Glug, Yum!"; 
		}
		public String getIdentifier() {
			return this.identifier;
		}
		
				
		//setters
		public void setPrice(double price) {
			this.price = price;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		public void setQuantity(int resetValue) {
			  this.quantity = resetValue;
		  }
		
		public void setIdentifier(String identifier) {
			this.identifier = identifier;
		}
		
		//derived methods
		
				
		
//		public int getAvailableQuantity(String id) {
//			  if(getNameOfBeverage(id).equals("Coke")) {
//				  return quantityCoke;
//			  } else if (getNameOfBeverage(id).equals("Sprite")) {
//				  return quantitySprite;
//			  } else {
//				  return quantityWater;
//			  }
//			  
//		  }
//	  
//	  public int getRemainingQuantity(int numberWanted, String id) {
//		  int quantity = 0;
//		  //check in qty wanted is greater than qty available
//		  if(getNameOfBeverage(id).equals("Coke")) {
//			  quantity = quantityCoke - numberWanted;
//		  } else if (getNameOfBeverage(id).equals("Sprite")) {
//			  quantity = quantitySprite - numberWanted;
//		  } else {
//			  quantity = quantityWater - numberWanted;
//		  }
//		  return quantity;
//	  }
	  
	  
	  
	 public void putBeverages(String identifier, double price) {
		 this.price = price;
		 allBeverages.put(identifier, this.price);
	 }
	 
	 @Override
	 public String toString() {
		
		 if(getQuantity() <= 0) {
			 return getIdentifier() + "|" + getName() + "|" + getPrice()/100.00D + "|" + "SOLD OUT";
		 }
		 return getIdentifier() + "|" + getName() + "|" + getPrice()/100.00D + "|" + getQuantity();
	 }
	 
	 public void reduceQuantity() {
		 this.quantity--;
	 }

	

	

	

	

}

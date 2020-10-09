package com.techelevator;

import java.util.HashMap;
import java.util.Map;

public class Chips {
	Map<String,Double> allChips = new HashMap<>();
	private double price;
	private int quantity;
	private String name;
	private String identifier;
	private String sound;
	
	
	//CTOR 
		public Chips(String identifier, String name, double price, int quantity ) {
			this.identifier = identifier;
			this.name = name;
			this.sound = "Crunch Crunch, Yum!";
			this.price = price;
			this.quantity = quantity;
			
		}
	
		///getters
		
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
			return "Crunch Crunch, Yum!";
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
		public void setQuantity(int value) {
			  this.quantity = value;
		  }
		
		public void setIdentifier(String identifier) {
			this.identifier = identifier;
		}
		
		
				
		
//		public int getAvailableQuantity(String id) {
//			  if(getNameOfChips(id).equals("Doritos")) {
//				  return quantityDoritos;
//			  } else if (getNameOfChips(id).equals("Lays")) {
//				  return quantityLays;
//			  } else {
//				  return quantityUtz;
//			  }
//			  
//		  }
//	  
//	  public int getRemainingQuantity(int numberWanted, String id) {
//		  int quantity = 0;
//		  if(getNameOfChips(id).equals("Doritos")) {
//			  quantity = quantityDoritos - numberWanted;
//		  } else if (getNameOfChips(id).equals("Extra")) {
//			  quantity = quantityLays - numberWanted;
//		  } else {
//			  quantity = quantityUtz - numberWanted;
//		  }
//		  return quantity;
//	  }
//	  
//	  public void setQuantity(int resetValues) {
//		  this.quantityDoritos = resetValues;
//		  this.quantityLays = resetValues;
//		  this.quantityUtz = resetValues;
//	  }
	  
	 public void putChips(String identifier, Double price) {
		 this.price = price;
		 allChips.put(identifier, this.price);
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

package com.techelevator;

import java.util.HashMap;
import java.util.Map;

public class Gum {
	Map<String,Double> allGum = new HashMap<>();
	private double price;
	private int quantity;
	private String name;
	private String identifier;
	private String sound;
	
	
	//CTOR 
	public Gum(String identifier, String name, double price, int quantity ) {
		this.identifier = identifier;
		this.name = name;
		this.sound = "Chew Chew, Yum!";
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
				return "Chew Chew, Yum!";
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
			
		
		
				
		
//	  public int getAvailableQuantity(String id) {
//		  if(getNameOfGum(id).equals("Orbit")) {
//			  return quantityOrbit;
//		  } else if (getNameOfGum(id).equals("Extra")) {
//			  return quantityExtra;
//		  } else {
//			  return quantityTrident;
//		  }
//		  
//	  }
//	  
//	  public int getRemainingQuantity(int numberWanted, String id) {
//		  int quantity = 0;
//		  if(getNameOfGum(id).equals("Orbit")) {
//			  quantity = quantityOrbit - numberWanted;
//		  } else if (getNameOfGum(id).equals("Extra")) {
//			  quantity = quantityExtra - numberWanted;
//		  } else {
//			  quantity = quantityTrident - numberWanted;
//		  }
//		  return quantity;
//	  }
//	  
//	  public void setQuantity(int resetValues) {
//		  this.quantityOrbit = resetValues;
//		  this.quantityExtra = resetValues;
//		  this.quantityTrident = resetValues;
//	  }
	  
	 public void putGum(String identifier, Double price) {
		 this.price = price;
		 allGum.put(identifier, this.price);
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

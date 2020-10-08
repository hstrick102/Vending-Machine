package com.techelevator;

import java.util.HashMap;
import java.util.Map;

public class Gum {
	Map<String,String> allGum = new HashMap<>();
	private static final double price = 75.0D;
	private static int quantityOrbit;
	private static int quantityExtra;
	private static int quantityTrident;
	
	
	//CTOR
	public Gum() {
		putGum();
		
	}
	
		//getters
		
		public double getPrice() {
			return (price / 100.0D);
		}
		
		//derived methods
		public String getNameOfGum(String identifier) {
			return allGum.get(identifier);
		}
				
		
	  public int getAvailableQuantity(String id) {
		  if(getNameOfGum(id).equals("Orbit")) {
			  return quantityOrbit;
		  } else if (getNameOfGum(id).equals("Extra")) {
			  return quantityExtra;
		  } else {
			  return quantityTrident;
		  }
		  
	  }
	  
	  public int getRemainingQuantity(int numberWanted, String id) {
		  int quantity = 0;
		  if(getNameOfGum(id).equals("Orbit")) {
			  quantity = quantityOrbit - numberWanted;
		  } else if (getNameOfGum(id).equals("Extra")) {
			  quantity = quantityExtra - numberWanted;
		  } else {
			  quantity = quantityTrident - numberWanted;
		  }
		  return quantity;
	  }
	  
	  public void setQuantity(int resetValues) {
		  this.quantityOrbit = resetValues;
		  this.quantityExtra = resetValues;
		  this.quantityTrident = resetValues;
	  }
	  
	 public void putGum() {
		 allGum.put("D1", "Orbit");
		 allGum.put("D2", "Extra");
		 allGum.put("D3", "Trident");
	 }

}

package com.techelevator;

import java.util.HashMap;
import java.util.Map;

public class Chips {
	Map<String,String> allChips = new HashMap<>();
	private static final double price = 175.0D;
	private static int quantityDoritos;
	private static int quantityLays;
	private static int quantityUtz;
	
	
	//CTOR
	public Chips() {
		putChips();
		
	}
	
		//getters
		
		public double getPrice() {
			return price;
		}
		
		//derived methods
		public String getNameOfChips(String identifier) {
			return allChips.get(identifier);
		}
				
		
		public int getAvailableQuantity(String id) {
			  if(getNameOfChips(id).equals("Doritos")) {
				  return quantityDoritos;
			  } else if (getNameOfChips(id).equals("Lays")) {
				  return quantityLays;
			  } else {
				  return quantityUtz;
			  }
			  
		  }
	  
	  public int getRemainingQuantity(int numberWanted, String id) {
		  int quantity = 0;
		  if(getNameOfChips(id).equals("Doritos")) {
			  quantity = quantityDoritos - numberWanted;
		  } else if (getNameOfChips(id).equals("Extra")) {
			  quantity = quantityLays - numberWanted;
		  } else {
			  quantity = quantityUtz - numberWanted;
		  }
		  return quantity;
	  }
	  
	  public void setQuantity(int resetValues) {
		  this.quantityDoritos = resetValues;
		  this.quantityLays = resetValues;
		  this.quantityUtz = resetValues;
	  }
	  
	 public void putChips() {
		 allChips.put("C1", "Doritos");
		 allChips.put("C2", "Lays");
		 allChips.put("C3", "Utz");
	 }


}

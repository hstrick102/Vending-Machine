package com.techelevator;

import java.util.HashMap;
import java.util.Map;

public class Candy {
	Map<String,String> allCandy = new HashMap<>();
	private static final double price = 150.0D;
	private static int quantityReeses;
	private static int quantitySnickers;
	private static int quantityStarbursts;
	
	
	//CTOR
	public Candy() {
		putCandy();
		
	}
	
		//getters
		
		public double getPrice() {
			return price;
		}
		
		//derived methods
		public String getNameOfCandy(String identifier) {
			return allCandy.get(identifier);
		}
				
		
		public int getAvailableQuantity(String id) {
			  if(getNameOfCandy(id).equals("Reeses")) {
				  return quantityReeses;
			  } else if (getNameOfCandy(id).equals("Snickers")) {
				  return quantitySnickers;
			  } else {
				  return quantityStarbursts;
			  }
			  
		  }
	  
	  public int getRemainingQuantity(int numberWanted, String id) {
		  int quantity = 0;
		  if(getNameOfCandy(id).equals("Reeses")) {
			  quantity = quantityReeses - numberWanted;
		  } else if (getNameOfCandy(id).equals("Snickers")) {
			  quantity = quantitySnickers - numberWanted;
		  } else {
			  quantity = quantityStarbursts - numberWanted;
		  }
		  return quantity;
	  }
	  
	  public void setQuantity(int resetValues) {
		  this.quantityReeses = resetValues;
		  this.quantitySnickers = resetValues;
		  this.quantityStarbursts = resetValues;
	  }
	  
	 public void putCandy() {
		 allCandy.put("B1", "Reeses");
		 allCandy.put("B2", "Snickers");
		 allCandy.put("B3", "Starburst");
	 }

}

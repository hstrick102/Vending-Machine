package com.techelevator;



public class Beverages implements Items {
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

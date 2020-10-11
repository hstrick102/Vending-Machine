package com.techelevator;


public class Chips implements Items{
	
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
	
		public void setQuantity(int value) {
			  this.quantity = value;
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

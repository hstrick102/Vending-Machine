package com.techelevator;

public class Items {
	private String name;
	private double price;
	
	//getters
	public double getPrice() {
		return price;
	}
	public String getName() {
		return name;
	}
	
	//CTOR
	public Items (String name, int price) {
		this.name = name;
		this.price = price;
	}

	
}

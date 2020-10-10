package com.techelevator;



public class Money {
	
	public String moneyFormatter(double money) {
		String formattedMoney = String.format("%.2f", money/100.0);
		return formattedMoney;
	}
	
	public String makeChange(double currentMoney) {
		//get remaining money out
		double quarter = 25;
		double dime = 10;
		double nickel = 5;
		double penny = 1;
		double numberOfQuarters =0;
		double numberOfDimes = 0;
		double numberOfNickels = 0;
		double numberOfPennies = 0;
		while(currentMoney > 0) {
			if(currentMoney >= quarter) {
			numberOfQuarters++;
			currentMoney -= quarter;
			}
			else if(currentMoney >= dime) {
			numberOfDimes++;
			currentMoney -= dime;
			}
			else if(currentMoney >= nickel) {
				numberOfNickels++;
				currentMoney -= nickel;
			}
			else {
				numberOfPennies++;
				currentMoney -= penny;
			}
			
		}
		return "Your Change Contains: " + numberOfQuarters+ " quarter(s), " + numberOfDimes+ " dime(s), " + 
		numberOfNickels+ " nickel(s), " + numberOfPennies + " pennies.";
	}
	

}

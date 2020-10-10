package com.techelevator.view;

import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import com.techelevator.Money;

import java.text.SimpleDateFormat;

public class LogWriter {
	
	
	Money money = new Money();
	
	
	//Writing to newFile
	public void logger(String transaction, double moneyIn, double currentBalance) {
		Date dateOfTransactions = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("mm-dd-yyyy hh:mm:ss");
		try(PrintWriter writer = new PrintWriter(new FileOutputStream(new File("Log.txt"), true))) {
			writer.println(formatter.format(dateOfTransactions) + " " + transaction + " $" + money.moneyFormatter(moneyIn) + " $" + money.moneyFormatter(currentBalance));
		} catch (IOException e) {
			System.out.println("Can't write to file");
		} 
	} 
		
	

}
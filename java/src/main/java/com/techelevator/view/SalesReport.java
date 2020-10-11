package com.techelevator.view;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;




public class SalesReport {
	
private int amount;
private String name;

public SalesReport(String name, int amount) {
	this.amount = amount;
	this.name = name;
}
	
	
	//Writing to newFile
	public void report() {
		Date dateOfTransactions = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
		try(PrintWriter writer = new PrintWriter(new FileOutputStream(new File(formatter.format(dateOfTransactions)+"SalesReport.txt"), true))) {
			writer.println(this.name + "|" + this.amount);
		} catch (IOException e) {
			System.out.println("Can't write to file");
		} 
		
	} 
	public void additionalItem() {
		amount++;
	}
	
}

package com.techelevator.view;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.junit.Test;


import com.techelevator.Money;



public class LogWriterTest {
	
	LogWriter logger = new LogWriter();
	File file = new File("Log.txt");
	//Beverages drink = new Beverages("A1", "Coke", 1.75, 500);
	Date date = new Date();
	SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
	Money money = new Money();
	@Test
	public void set_up() {
		if(file.exists()) {
			file.delete();
		}
	}
	@Test
	public void test_for_log_input() throws FileNotFoundException {
		
			set_up();
			logger.logger("Coke A1", 175, 500.0);
			Scanner scanner = new Scanner(file);
			while(scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String expected = formatter.format(date) + " Coke A1 $1.75 $5.00";
				assertEquals(expected, line);
			}
		
	}


	
}

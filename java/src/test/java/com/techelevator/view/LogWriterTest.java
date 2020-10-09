package com.techelevator.view;

import static org.junit.Assert.assertEquals;

import java.util.Scanner;

import org.junit.Test;



public class LogWriterTest {
	
	LogWriter logger = new LogWriter();
	Scanner scanner = new Scanner("Log.txt");
	
	
	@Test
	public void fakeLogTest () {
		logger.logger("A12, Coke", 5, 0);
		assertEquals(true, scanner.hasNextLine());
	}

}

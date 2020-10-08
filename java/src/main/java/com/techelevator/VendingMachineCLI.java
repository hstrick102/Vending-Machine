package com.techelevator;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import com.techelevator.view.Menu;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE };

	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() {
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// do purchase
			}
		}
	}

	public static void main(String[] args) throws IOException {
//		Menu menu = new Menu(System.in, System.out);
//		VendingMachineCLI cli = new VendingMachineCLI(menu);
//		cli.run();
		
		
		//create new file 
			File newFile = new File("input.txt");
			newFile.createNewFile();
				//check file has been created or exists
			if(!newFile.exists()) {
				System.out.println("Error - File not created");
			}
			
			//Writing to newFile
			try(PrintWriter writer = new PrintWriter(newFile.getAbsoluteFile())) {
				writer.println("Hello World");
			}
	}
}

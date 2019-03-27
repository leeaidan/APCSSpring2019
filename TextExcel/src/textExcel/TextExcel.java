/*
 * @author Aidan Lee
 * @version 1.0 3/6/2019
 * This class handles human input for TextExcel, calling other classes with the parameter of a
 * location(ie. "A3")
 */
package textExcel;

import java.io.FileNotFoundException;
import java.util.Scanner;

// Update this file with your own code.

public class TextExcel
{

	public static void main(String[] args)
	{
		 {
		    	Scanner userInput = new Scanner(System.in); //New Scanner declared
				String input = userInput.nextLine(); //Get input
				Spreadsheet sheet = new Spreadsheet();
				
				while(!input.equalsIgnoreCase("quit")) { //while quit is not typed, loop gives input to produce Answer
					System.out.println(sheet.processCommand(input));
					Location loc = new SpreadsheetLocation(input);
					System.out.println("row: " + loc.getRow());
					System.out.println("col: " + loc.getCol());
					System.out.println("Enter a command:");
					input = userInput.nextLine();
		    	}
		    	userInput.close(); //closes Scanner to conserve memory when user is finished

		    }
	}
}

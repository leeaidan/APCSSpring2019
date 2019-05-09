
/*
 * @author Aidan Lee
 * @version 1.0 3/6/2019
 * A subclass of RealCell that handles formula commands including Average and Sum.
 */
package textExcel;

import java.util.ArrayList;

public class FormulaCell extends RealCell{
	Spreadsheet sheet;
	
	//Calls RealCell Super and assigns inputed Spreadsheet to a field
	public FormulaCell(String input, Spreadsheet sheet) {
		super(input);
		this.sheet = sheet;
		
		
	}

	//returns the result of the formula inputed as a double value. Then it can be displayed using the inheirited methods froM RealCell
	public double getDoubleValue() {
		
		String abv = getInput().substring(2, (getInput().length()-1));
		String[] splitArgument = abv.split(" "); //splits by spaces to form operand and operator
		double answer=0;
		
		if(splitArgument[0].equalsIgnoreCase("SUM") || splitArgument[0].equalsIgnoreCase("AVG")) {//AVG is SUM/#of values so can be calculated together
			ArrayList<RealCell> rangeContents = new ArrayList<RealCell>();//ArrayList to store for simplicity and avoid messy Array reassignments
			
			String splitRange[] = splitArgument[1].split("-");
			SpreadsheetLocation begin = new SpreadsheetLocation(splitRange[0]);//beginning location for SUM/AVG
			SpreadsheetLocation end = new SpreadsheetLocation(splitRange[1]);//end location for SUM/AVG
			
			//For loop that gets the values needed to calculate sum
			for(int row = begin.getRow(); row<= end.getRow(); row++) {
				for(int col = begin.getCol(); col <= end.getCol(); col++ ) {
					String stringLoc = Character.toString((char) (col + 65)) + Integer.toString(row + 1);//Converts Location given by row and column for loop variables into a coherent and connected String
			
					SpreadsheetLocation loc = new SpreadsheetLocation(stringLoc);
					rangeContents.add((RealCell) sheet.getCell(loc));//Casting to RealCell to make calculations simpler later
				}
			}
			
			//Calculates SUM of the specified range
			for(int i = 0; i< rangeContents.size(); i++) {
				answer += rangeContents.get(i).getDoubleValue();
			}
			
			//If Average is invoked, divides by the # of ArrayList elements by the SUm
			if(splitArgument[0].equalsIgnoreCase("AVG")) {
				answer /= (double) rangeContents.size();
			}
			
			
			
			
		} else {//IF AVG and SUM are not detected in the formula
		
			//Checks that the input is within the characters specified by the requirements(Letters) and creates a new location at the specified input. Then modifies the array with the value of that cell as a Double
			for(int i = 0; i < splitArgument.length; i++) {
				if((((splitArgument[i].charAt(0)) >= 'A' && splitArgument[i].charAt(0) <= 'L')) || (splitArgument[i].charAt(0) >= 'a' && splitArgument[i].charAt(0) <= 'l')){
					SpreadsheetLocation loc = new SpreadsheetLocation(splitArgument[i]);
					splitArgument[i] = (((RealCell) sheet.getCell(loc)).getDoubleValue()) + "";
				}
			}
		
			answer = Double.parseDouble(splitArgument[0]);//needs intial value to allow loop to function properly
			for(int i = 0; i< splitArgument.length; i++) {//all arguments contain i+1 bc of the of the alternative pattern of operand and operator
				if(splitArgument[i].equals("+")) {
					answer += Double.parseDouble(splitArgument[i+1]);//Addition
				} else if(splitArgument[i].equals("-")){				
					answer -= Double.parseDouble(splitArgument[i+1]);//Subtraction
				} else if(splitArgument[i].equals("*")) {
					answer *= Double.parseDouble(splitArgument[i+1]);//Multiplication	
				} else if(splitArgument[i].equals("/")) {
					answer /= Double.parseDouble(splitArgument[i+1]);//Division
				}
			
			}
		}
		return answer;
	}
}


/*
 * @author Aidan Lee
 * @version 1.0 3/6/2019
 */
package textExcel;

import java.util.ArrayList;

public class FormulaCell extends RealCell{
	Spreadsheet sheet;
	public FormulaCell(String input) {
		super(input);
		
	}

	public double getDoubleValue() {
		String abv = getInput().substring(2, (getInput().length()-1));
		String[] splitArgument = abv.split(" "); //splits by spaces to form operand and operator
		double answer=0;
		
		if(splitArgument[0].equalsIgnoreCase("SUM") || splitArgument[0].equalsIgnoreCase("AVG")) {
			ArrayList<RealCell> rangeContents = new ArrayList<RealCell>();
			
			String splitRange[] = splitArgument[1].split("-");
			SpreadsheetLocation begin = new SpreadsheetLocation(splitRange[0]);
			SpreadsheetLocation end = new SpreadsheetLocation(splitRange[1]);
			
			for(int row = begin.getRow(); row<= end.getRow(); row++) {
				for(int col = begin.getCol(); col <= end.getCol(); col++ ) {
					String stringLoc = Character.toString((char) (col + 65)) + Integer.toString(row + 1);
					System.out.println(stringLoc);
					SpreadsheetLocation loc = new SpreadsheetLocation(stringLoc);
					rangeContents.add((RealCell) sheet.getCell(loc));
				}
			}
			
			for(int i = 0; i< rangeContents.size(); i++) {
				answer += rangeContents.get(i).getDoubleValue();
			}
			
			if(splitArgument[0].equalsIgnoreCase("AVG")) {
				answer /= (double) rangeContents.size();
			}
			
			
			
			
		} else {
		
			for(int i = 0; i < splitArgument.length; i++) {
				if((((splitArgument[i].charAt(0)) >= 'A' && splitArgument[i].charAt(0) <= 'L')) || (splitArgument[i].charAt(0) >= 'a' && splitArgument[i].charAt(0) <= 'l')){
					SpreadsheetLocation loc = new SpreadsheetLocation(splitArgument[i]);
					splitArgument[i] = (((RealCell) sheet.getCell(loc)).getDoubleValue()) + "";
				}
			}
		
			answer = Double.parseDouble(splitArgument[0]);//needs intial value to allow loop to function properly
			for(int i = 0; i< splitArgument.length; i++) {//all arguments contain i+1 bc of the of the alternative pattern of operand and operator
				if(splitArgument[i].equals("+")) {
					answer += Double.parseDouble(splitArgument[i+1]);
				} else if(splitArgument[i].equals("-")){
					answer -= Double.parseDouble(splitArgument[i+1]);
				} else if(splitArgument[i].equals("*")) {
					answer *= Double.parseDouble(splitArgument[i+1]);
				} else if(splitArgument[i].equals("/")) {
					answer /= Double.parseDouble(splitArgument[i+1]);
				}
			
			}
		}
		return answer;
	}
}


/*
 * @author Aidan Lee
 * @version 1.0 3/6/2019
 */
package textExcel;

public class FormulaCell extends RealCell{
	Spreadsheet sheet;
	public FormulaCell(String input) {
		super(input);
		
	}

	public double getDoubleValue() {
		String abv = getInput().substring(2, (getInput().length()-1));
		String[] splitArgument = abv.split(" "); //splits by spaces to form operand and operator
		
		for(int i = 0; i < splitArgument.length; i++) {
			if((((splitArgument[i].charAt(0)) >= 'A' && splitArgument[i].charAt(0) <= 'L')) || (splitArgument[i].charAt(0) >= 'a' && splitArgument[i].charAt(0) <= 'l')){
				SpreadsheetLocation loc = new SpreadsheetLocation(splitArgument[i]);
				splitArgument[i] = (((RealCell) sheet.getCell(loc)).getDoubleValue()) + "";
			}
		}
		
		double answer = Double.parseDouble(splitArgument[0]);//needs intial value to allow loop to function properly
		for(int i = 0; i< splitArgument.length; i++) {//all arguments contain i+1 bc of the intial value
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
		
		return answer;
	}
}

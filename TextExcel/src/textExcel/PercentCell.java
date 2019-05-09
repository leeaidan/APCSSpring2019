/*
 * @author Aidan Lee
 * @version 1.0 3/6/2019
 * 
 * Subclass of RealCell that handles a command where one wants to put percentages in a certain cell.
 */

package textExcel;

public class PercentCell extends RealCell {

	//Calls Super - RealCell 
	public PercentCell(String input) {
		super(input);		
	}
	
	//Returns the the abbreviated form of the percentage, found through getDoubleValue() and adding percentage sign
	public String abbreviatedCellText() 
	{
		String abv = (int) (getDoubleValue()*100) + "%          ";
		return abv.substring(0,10);
	}

	//Returns a String that is equal to the percent from getDoubleValue() --> Casting to String
	public String fullCellText() {
		return "" + getDoubleValue();
	}
	
	//Gets the original input and returns the original String input as a double value(no percent sign).
	public double getDoubleValue() {
		
		String temp = getInput().substring(0, (getInput().length() -1));
		return Double.parseDouble(temp) / 100;
	}
	

}



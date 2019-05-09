/*
 * @author Aidan Lee
 * @version 1.0 3/6/2019
 * Superclass. Contains basic functionality for abbreviatedCellText(), fullCellText(0 and getDoubleValue()
 * that may or may not need to be overridden in its subclasses.
 */
package textExcel;

public class RealCell implements Cell {
	private String input;
	
	//Constructor to assign input to a field
	public RealCell(String input) {
		this.input = input;
	}
	
	//Returns a the original string that is only 10 characters long
	public String abbreviatedCellText() {
		String abv = getDoubleValue() + "          ";
		return abv.substring(0,10);
	}
	
	//Returns original input
	public String fullCellText() {
		return input;
	}
	
	//Returns original String as a double through parseDouble() method
	public double getDoubleValue() {//called by subclasses
		return Double.parseDouble(input);
	}
	
	//Getter for the field "input" for the subclasses of RealCell
	public String getInput() {
		return input;
	}

	
	
}

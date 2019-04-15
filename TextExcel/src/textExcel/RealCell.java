/*
 * @author Aidan Lee
 * @version 1.0 3/6/2019
 */
package textExcel;

public class RealCell implements Cell {
	protected String input;
	
	public RealCell(String input) {
		this.input = input;
	}
	public String abbreviatedCellText() {
		String abv = getDoubleValue() + "          ";
		return abv.substring(0,10);
	}
	public String fullCellText() {
		return input;
	}
	
	public double getDoubleValue() {//called by subclasses
		return Double.parseDouble(input);
	}
	
	public String getInput() {
		return input;
	}

	
	
}

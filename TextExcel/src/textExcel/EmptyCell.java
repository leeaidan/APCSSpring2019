/*
 * @author Aidan Lee
 * @version 1.0 3/6/2019
 * The default cell for a certain cell of the grid when no other type of cell is in place. 
 * Implements the Cell Interface.
 */
package textExcel;

public class EmptyCell implements Cell
{
	public EmptyCell() {
		//empty constructor - nothing me
	}
	
	public String abbreviatedCellText() {
		return "          ";
		// text for spreadsheet cell display, must be exactly length 10
	}
	public String fullCellText() {
		return "";
		//returns nothing bc...its a cell with nothing in it
	}
	
}

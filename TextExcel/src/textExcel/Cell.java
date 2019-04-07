/*
 * @author Aidan Lee
 * @version 1.0 3/6/2019
 */
package textExcel;

//*******************************************************
// DO NOT MODIFY THIS FILE!!!
//*******************************************************

public interface Cell
{
	public String abbreviatedCellText(); // text for spreadsheet cell display, must be exactly length 10
	public String fullCellText(); // text for individual cell inspection, not truncated or padded
}

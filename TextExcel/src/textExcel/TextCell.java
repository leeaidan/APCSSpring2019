/*
 * @author Aidan Lee
 * @version 1.0 3/6/2019
 * 
 *Implements Cell. A cell that handles only text inputs and its proper methods for functionality.
 */
package textExcel;

public class TextCell implements Cell {
	private String text;
	
	//Constructor for Text Cell - gets rid of quotes in input if needed.
	public TextCell(String text) {
		if(text.indexOf("\"") != -1) {
			this.text = text.substring(1, text.length() -1);
		} else {
			this.text =text;
		}
	}
	
	//Returns text but only first 10 characters
	public String abbreviatedCellText() {
		String abvText = text + "          ";
		return abvText.substring(0, 10);
	}
	
	//returns entire input string but adds the quotes back.
	public String fullCellText() {
		return "\"" + text + "\"";
	}

}

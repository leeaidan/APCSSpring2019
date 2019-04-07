/*
 * @author Aidan Lee
 * @version 1.0 3/6/2019
 */
package textExcel;

public class TextCell implements Cell {
	private String text;
	
	public TextCell(String text) {
		if(text.indexOf("\"") != -1) {
			this.text = text.substring(1, text.length() -1);
		} else {
			this.text =text;
		}
	}
	
	public String abbreviatedCellText() {
		String abvText = text + "          ";
		return abvText.substring(0, 10);
	}
	public String fullCellText() {
		return "\"" + text + "\"";
	}

}

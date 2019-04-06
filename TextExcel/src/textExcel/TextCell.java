package textExcel;

public class TextCell implements Cell {
	private String text;
	
	public TextCell(String text) {
		if(text.indexOf("\"") >= 0) {
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

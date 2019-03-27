package textExcel;

public class TextCell implements Cell {
	String text;
	
	public TextCell(String text) {
		this.text = text;
	}
	
	public String abbreviatedCellText() {
		String abvText = text + "          ";
		return abvText.substring(0, 10);
	}
	public String fullCellText() {
		return "\"" + text + "\"";
	}

}

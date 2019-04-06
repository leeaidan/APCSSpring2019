package textExcel;

public class RealCell implements Cell {
	private String input;
	
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
	
	public double getDoubleValue() {
		return Double.parseDouble(input);
	}
}

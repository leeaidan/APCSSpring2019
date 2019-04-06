package textExcel;

public class FormulaCell extends RealCell{
	
	public FormulaCell(String input) {
		super(input);
	}
	
	public String abbreviatedCellText() {
		return super.abbreviatedCellText();
	}
	
	public String fullCellText() {
		return super.fullCellText();
	}
	
	public double getDoubleValue() {
		return 0; //placeholder
	}
}

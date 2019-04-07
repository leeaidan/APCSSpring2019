/*
 * @author Aidan Lee
 * @version 1.0 3/6/2019
 */
package textExcel;

public class ValueCell extends RealCell {
	private String input;
	
	public ValueCell(String input) {
		super(input);
		this.input = input;
		
	}
	
	public String abbreviatedCellText() {//nvm parseDouble fixes everything
		return super.abbreviatedCellText();
	}
	

	public String fullCellText() {
		return super.fullCellText();
	}
	
	public double getDoubleValue() {
		return super.getDoubleValue();
	}
}

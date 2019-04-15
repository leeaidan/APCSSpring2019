package textExcel;

public class PercentCell extends RealCell {
	//private String input;
	
	public PercentCell(String input) {
		super(input);
		//this.input = input;
		
	}
	
	public String abbreviatedCellText() 
	{
		String abv = (int) (getDoubleValue()*100) + "%          ";
		return abv.substring(0,10);
	}

	public String fullCellText() {
		return "" + getDoubleValue();
	}
	
	public double getDoubleValue() {
		
		String temp = getInput().substring(0, (getInput().length() -1));
		return Double.parseDouble(temp) / 100;
	}
	

}




/*
 * @author Aidan Lee
 * @version 1.0 3/6/2019
 */
package textExcel;

public class FormulaCell extends RealCell{
	private String input;
	
	public FormulaCell(String input) {
		super(input);
		this.input = input;
	}
	
	public String abbreviatedCellText() {
		return super.abbreviatedCellText();
	}
	
	public String fullCellText() {
		return super.fullCellText();
	}
	
	public double getDoubleValue() {
		String abv = input.substring(2, (input.length()-1));
		String[] splitArgument = abv.split(" "); //splits by spaces to form operand and operator
		
		double answer = Double.parseDouble(splitArgument[0]);//needs intial value to allow loop to function properly
		for(int i = 0; i< splitArgument.length; i++) {//all arguments contain i+1 bc of the intial value
			if(splitArgument[i].equals("+")) {
				answer += Double.parseDouble(splitArgument[i+1]);
			} else if(splitArgument[i].equals("-")){
				answer -= Double.parseDouble(splitArgument[i+1]);
			} else if(splitArgument[i].equals("*")) {
				answer *= Double.parseDouble(splitArgument[i+1]);
			} else if(splitArgument[i].equals("/")) {
				answer /= Double.parseDouble(splitArgument[i+1]);
			}
			
		
		}
		
		return answer;
	}
}

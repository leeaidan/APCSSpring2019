/*
 * @author Aidan Lee
 * @version 1.0 3/6/2019
 */
package textExcel;

public class Spreadsheet implements Grid
{
	private Cell[][] cell;
	private int numRow, numCol;
	
	public Spreadsheet() {
		numRow = 20;
		numCol = 12;
		cell = new Cell[numRow][numCol];
		
		clear("clear");
	}
	
	@Override
	public String processCommand(String command)
	{
		
		if(command.length() == 2 || command.length() == 3) {
			return getCell(new SpreadsheetLocation(command)).fullCellText();
			
		}else if(command.toLowerCase().startsWith("clear")) { //clearing cells and sheet, NOTE(for some reason only contains doesn't work rip)
			clear(command);
			return getGridText();
			
		} else if(command.indexOf("=") != -1){ //assignment
			cellAssignment(command);
			return getGridText();
		
		} else {
			return "";
		}
	
	}
	
	public void clear(String index) {
	
		if(index.equalsIgnoreCase("clear")) {
			for(int row = 0; row < getRows(); row++) {
				for(int column = 0; column< getCols(); column++) {
					cell[row][column] = new EmptyCell();
				}
			}
		} else {
			String[] splitIndex = index.split(" ");
			SpreadsheetLocation loc = new SpreadsheetLocation(splitIndex[1]);
			cell[loc.getRow()][loc.getCol()] = new EmptyCell();
		}
	}
	
	public void cellAssignment(String input) {
		String[] splitAssignment = input.split(" = ", 2);
		SpreadsheetLocation loc = new SpreadsheetLocation(splitAssignment[0]);
		if(splitAssignment[1].contains("\"")){
			cell[loc.getRow()][loc.getCol()] = new TextCell(splitAssignment[1]);
		} else if(splitAssignment[1].contains("%")) {
			cell[loc.getRow()][loc.getCol()] = new PercentCell(splitAssignment[1]);
		} else if(splitAssignment[1].contains("(")) {
			cell[loc.getRow()][loc.getCol()] = new FormulaCell(splitAssignment[1]);
		} else {
			cell[loc.getRow()][loc.getCol()] = new ValueCell(splitAssignment[1]);
		}
	}
	 

	@Override
	public int getRows()
	{
		// TODO Auto-generated method stub
		return 20;
	}

	@Override
	public int getCols()
	{
		// TODO Auto-generated method stub
		return 12;
	}

	@Override
	public Cell getCell(Location loc)
	{
		return cell[loc.getRow()][loc.getCol()];
	}
	
	@Override
	public String getGridText() 
	{
		String spreadsheetGrid = "   |";
		for(int i = 'A'; i <= 'L'; i++) {
			spreadsheetGrid = spreadsheetGrid + ((char) i + "         |");
		}
		
		spreadsheetGrid +="\n";
		for(int row =1; row <= numRow; row++) {
			if(row<10) {
				spreadsheetGrid += row + "  |";
			}else {
				spreadsheetGrid += row + " |";
			}
			
		for(int col=0; col< numCol; col++) {
			spreadsheetGrid += cell[row-1][col].abbreviatedCellText();
			spreadsheetGrid += "|";
		}	
			spreadsheetGrid += "\n";
		}
		
		return spreadsheetGrid;
		
	}

}

/*
 * @author Aidan Lee
 * @version 1.0 3/6/2019
 * Class Spreadsheet takes in user inputs and decides how to change or return values in the spreadsheet.
 * It is also responsible for printing out the entire spreadsheet after changes.
 */
package textExcel;

public class Spreadsheet implements Grid
{
	private Cell[][] sheet;
	private int numRow, numCol;
	
	//assigns Number of Rows and Columns in Spreadsheet, creates new spreadsheet and assigns EmptyCells to all cells.
	public Spreadsheet() {
		numRow = 20;
		numCol = 12;
		sheet = new Cell[numRow][numCol];
		
		clear("clear");
	}
	
	@Override
	//Method for deciding which operation to preform on the input.
	public String processCommand(String command)
	{
		
		if(command.length() == 2 || command.length() == 3) {//getCell Value
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
	
	//Void Method that clears each index of the 2-D Array(spreadsheet) --> replaces with EmptyCell or clears a certain index given by an input
	public void clear(String index) {
	
		if(index.equalsIgnoreCase("clear")) {//clears entire sheet
			for(int row = 0; row < getRows(); row++) {
				for(int column = 0; column< getCols(); column++) {
					sheet[row][column] = new EmptyCell();
				}
			}
		} else {//clears individual cell
			String[] splitIndex = index.split(" ");
			SpreadsheetLocation loc = new SpreadsheetLocation(splitIndex[1]);
			sheet[loc.getRow()][loc.getCol()] = new EmptyCell();
		}
	}
	
	public void cellAssignment(String input) {//Void method that assigns input to its proper cell
		String[] splitAssignment = input.split(" = ", 2);
		SpreadsheetLocation loc = new SpreadsheetLocation(splitAssignment[0]);
		if(splitAssignment[1].contains("\"")){
			sheet[loc.getRow()][loc.getCol()] = new TextCell(splitAssignment[1]);
		} else if(splitAssignment[1].contains("%")) {
			sheet[loc.getRow()][loc.getCol()] = new PercentCell(splitAssignment[1]);
		} else if(splitAssignment[1].contains("(")) {
			sheet[loc.getRow()][loc.getCol()] = new FormulaCell(splitAssignment[1], this);
		} else {
			sheet[loc.getRow()][loc.getCol()] = new ValueCell(splitAssignment[1]);
		}
	}
	 

	@Override
	//get # of rows in Spreadsheet
	public int getRows()
	{
		// TODO Auto-generated method stub
		return 20;
	}

	@Override
	//get # of columns in Spreadsheet
	public int getCols()
	{
		// TODO Auto-generated method stub
		return 12;
	}

	@Override
	//Gets a cell value at input Location
	public Cell getCell(Location loc)
	{
		return sheet[loc.getRow()][loc.getCol()];
	}
	
	@Override
	//Prints out entire spreadsheet(grid) whether modifications have been done or not
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
			spreadsheetGrid += sheet[row-1][col].abbreviatedCellText();
			spreadsheetGrid += "|";
		}	
			spreadsheetGrid += "\n";
		}
		
		return spreadsheetGrid;
		
	}

}

package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid
{
	private Cell[][] cell;
	private int numRow, numCol;
	
	public Spreadsheet() {
		numRow = 20;
		numCol = 12;
		cell = new Cell[numRow][numCol];
		for(int row = 0; row < numRow; row++) {
			for(int col = 0; col < numCol; col++) {
				cell[row][col] = new EmptyCell();
			}
		}
	}
	
	@Override
	public String processCommand(String command)
	{
		
		if(command.length() == 2 || command.length() == 3) {
			return getCell(new SpreadsheetLocation(command)).fullCellText();
			
		}else if(command.substring(0,5).equalsIgnoreCase("clear")) { //clearing cells and sheet, NOTE(for some reason only contains doesn't work rip)
			clear(command);
			return getGridText();
			
		} else { //assignment
			cellAssignment(command);
			return getGridText();
		
		}
	
	}
	
	public void clear(String index) {
	
		if(index.equalsIgnoreCase("clear")) {
			for(int i = 0; i < getRows(); i++) {
				for(int j = 0; j< getCols(); j++) {
					cell[i][j] = new EmptyCell();
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
		
		for(int j =0; j<numRow; j++) {
			if((j+1)<10) {
				spreadsheetGrid += ("\n" + (j+1) + "  |");
			}else {
				spreadsheetGrid +=("\n" + (j+1) + " |");
			}
			
			
		for(int k=0; k< numCol; k++) {
				spreadsheetGrid += cell[j][k].abbreviatedCellText();
				for(int l = cell[j][k].abbreviatedCellText().length(); l < 10; l++){
					spreadsheetGrid += " ";
				}
				spreadsheetGrid += "|";
			}
				
			
			
		}
		
		return spreadsheetGrid + "\n";
		
		
	}

}

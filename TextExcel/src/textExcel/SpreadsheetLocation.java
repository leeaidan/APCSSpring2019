package textExcel;

//Update this file with your own code.

public class SpreadsheetLocation implements Location
{
	private int row, column;
    @Override
    public int getRow()
    {
        // TODO Auto-generated method stub
        return row;
    }

    @Override
    public int getCol()
    {
        // TODO Auto-generated method stub
        return column;
    }
    
    public SpreadsheetLocation(String cellName)
    {
        // TODO: Fill this out with your own code
    	
    	row = Integer.parseInt(cellName.substring(1)) -1; //-1 to offset from the headers
    	column = cellName.toUpperCase().charAt(0) -65;
    	    	
    	
    }

}

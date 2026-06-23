
/**
 * TextUserDisplay here.
 */
class TerminalUserDisplay implements UserDisplay {
    private static final char UNICODE_CLEAR_SCREEN_COMMAND = '\u000C';
    private static final char ALIVE_CELL_SYMBOL = 'W';
    private static final char DEAD_CELL_SYMBOL = '`';
    
    /**
     * Constructor for objects of class TextUserDisplay
     */
    TerminalUserDisplay(){
        //
    }
    
    /**
     * Displays a grid of cells using text
     *
     * @param grid the grid to display
     */
    public void update(Cell[][] grid) {
        char[] displayBuffer = printableBufferFromGrid(grid);
        clearScreen();
        System.out.print(displayBuffer);
    }
    
    private void clearScreen() {
        System.out.print(UNICODE_CLEAR_SCREEN_COMMAND);
    }
    
    private char[] printableBufferFromGrid(Cell[][] grid) {
        char[] symbolBuffer = new char[grid.length * (grid[0].length + 1)];
        
        for(int row=0;row<grid.length;row++) {
            for(int column=0;column<grid[row].length;column++) {
                Cell cell = grid[row][column];
                char cellSymbol = symbolFromCell(cell);
                
                int index = row * grid[row].length + column + row;
                symbolBuffer[index] = cellSymbol;
            }
            int index = row * grid[row].length + grid[row].length + row;
            symbolBuffer[index] = '\n';
        }
        
        return symbolBuffer;
    }
    
    /**
     * Returns the corrosponding symbol of a cell, which depends on if it's alive
     *
     * @param  the cell
     * @return the symbol
     */
    private char symbolFromCell(Cell cell) {
        if(cell == Cell.ALIVE) {
            return ALIVE_CELL_SYMBOL;
        } else {
            return DEAD_CELL_SYMBOL;
        }
    }
}

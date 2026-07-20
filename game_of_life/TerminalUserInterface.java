
/**
 * User Interface.
 */
class TerminalUserInterface implements UserInterface {
    private static final char UNICODE_CLEAR_SCREEN_COMMAND = '\u000C';
    private static final char ALIVE_CELL_SYMBOL = 'W';
    private static final char DEAD_CELL_SYMBOL = '`';
    
    /**
     * Constructor for objects of class UI
     */
    TerminalUserInterface() {
        
    }
    
    static GameUI terminalGameUI() {
        var display = new TerminalGameUserDisplay();
        var input = new TerminalGameUserInput();
        var terminalInstance = new TerminalGameUI(display, input);
        return terminalInstance;
    }
    
    void updateDisplay(Cell[][] grid) {
        updateGrid(grid);
    }
    
    void askUserForAction(String prompt) {
        promptUserForAction(prompt);
        getUserAction();
    }
    
    GameUserAction userAction() {
        GameUserAction action = userAction();
        assert(action != null);
        return action;
    }
    
    /**
     * Display a specified grid.
     *
     * @param grid the grid to display
     */
    public void updateGrid(Cell[][] grid) {
        char[] displayBuffer = printableBufferFromGrid(grid);
        clearTerminal();
        System.out.print(displayBuffer);
    }
    
    /**
     * Display a prompt for the user.
     *
     * @param prompt the prompt
     */
    public void promptUserForAction(String prompt) {
        System.out.println("=========================");
        System.out.println(prompt);
    }
    
    /**
     * Clear the terminal
     */
    private void clearTerminal() {
        System.out.print(UNICODE_CLEAR_SCREEN_COMMAND);
    }
    
    /**
     * Return a ready to print buffer of a given grid's cell representations
     */
    private char[] printableBufferFromGrid(Cell[][] grid) {
        char[] symbolBuffer = new char[grid.length * (grid[0].length + 1)];
        
        for(int row=0;row<grid.length;row++) {
            for(int column=0;column<grid[row].length;column++) {
                Cell cell = grid[row][column];
                char cellSymbol = charRepresentationFromCell(cell);
                
                int index = row * grid[row].length + column + row;
                symbolBuffer[index] = cellSymbol;
            }
            int index = row * grid[row].length + grid[row].length + row;
            symbolBuffer[index] = '\n';
        }
        
        return symbolBuffer;
    }
    
    /**
     * Return a representation, to be used in the terminal, for a specified cell dependant on if it's alive or not
     *
     * @param  the cell
     * @return the representation
     */
    private char charRepresentationFromCell(Cell cell) {
        if(cell == Cell.ALIVE) {
            return ALIVE_CELL_SYMBOL;
        } else {
            return DEAD_CELL_SYMBOL;
        }
    }
}

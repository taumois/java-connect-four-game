
/**
 * Can display everything necessary for a Game
 */
interface GameUserDisplay {
    
    /**
     * Updates the displayed grid i.e. cells
     *
     * @param grid the grid to display
     */
    public void updateGrid(Cell[][] grid);
    
    /**
     * Displays a prompt for the user
     *
     * @param prompt for the user
     */
    public void promptUserForAction(String prompt);
}

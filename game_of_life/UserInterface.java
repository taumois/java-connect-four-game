
/**
 * 
 */
public interface UserInterface {
    /**
     * Update the grid displayed to the user.
     * 
     * @param grid the new grid to replace the displayed with
     */
    public void updateGrid(char[] grid);
    
    /**
     * Create and display a prompt to the user for boolean input.
     * 
     * @param prompt the message in the prompt
     */
    public void createInputPrompt(String prompt);
    
    /**
     * Be returned 
     */
    public UserAction userInputAction();
}

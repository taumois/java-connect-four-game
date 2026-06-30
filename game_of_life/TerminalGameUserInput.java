
/**
 * TerminalUserInput here.
 */
class TerminalGameUserInput implements GameUserInput {
    private GameUserAction mostRecentUserAction;
    
    TerminalGameUserInput() {
        
    }
    
    /**
     * Gets(but doesn't return) an action/input from the user
     */
    public void getUserAction() {
        mostRecentUserAction = new GameUserAction();
    }
    
    /**
     * Returns the users most recent action/input(if available)
     */
    public GameUserAction userAction() {
        return mostRecentUserAction;
    }
}

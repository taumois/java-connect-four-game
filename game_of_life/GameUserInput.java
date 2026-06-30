
/**
 * UserInput here.
 */
interface GameUserInput {
    
    /**
     * Gets(but doesn't return) an action/input from the user
     */
    public void getUserAction();
    
    /**
     * Returns the users most recent action/input(if available)
     */
    public GameUserAction userAction();
}

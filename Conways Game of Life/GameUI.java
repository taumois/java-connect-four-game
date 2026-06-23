
/**
 * User Interface.
 *
 * @author Isaiah Taumoepeau
 */
class GameUI {
    private final UserDisplay DISPLAY;
    private final UserInput INPUT;
    
    private UserAction previousUserAction;
    
    /**
     * Constructor for objects of class UI
     */
    GameUI(UserDisplay display, UserInput input) {
        this.DISPLAY = display;
        this.INPUT = input;
    }
    
    void updateDisplay(Cell[][] grid) {
        DISPLAY.update(grid);
    }
    
    void askUserForAction() {
        UserAction userAction = INPUT.userAction();
    }
    
    UserAction userAction() {
        try {
            return previousUserAction;
        } catch(NullPointerException exception) {
            askUserForAction();
            return previousUserAction;
        }
    }
}

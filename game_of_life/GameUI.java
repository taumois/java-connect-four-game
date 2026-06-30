
/**
 * User Interface.
 *
 * @author Isaiah Taumoepeau
 */
class GameUI {
    private final GameUserDisplay DISPLAY;
    private final GameUserInput INPUT;
    
    /**
     * Constructor for objects of class UI
     */
    GameUI(GameUserDisplay display, GameUserInput input) {
        this.DISPLAY = display;
        this.INPUT = input;
    }
    
    static GameUI terminalGameUI() {
        var display = new TerminalGameUserDisplay();
        var input = new TerminalGameUserInput();
        var terminalInstance = new GameUI(display, input);
        return terminalInstance;
    }
    
    void updateDisplay(Cell[][] grid) {
        DISPLAY.updateGrid(grid);
    }
    
    void askUserForAction(String prompt) {
        DISPLAY.promptUserForAction(prompt);
        INPUT.getUserAction();
    }
    
    GameUserAction userAction() {
        GameUserAction action = INPUT.userAction();
        assert(action != null);
        return action;
    }
}

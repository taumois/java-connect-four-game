
/**
 * GameFactory here.
 */
public class GameFactory {
    
    /**
     * Constructs an example object of ConwaysGameOfLife
     *
     * @return the object
     */
    public static ConwaysGameOfLife egGame() {
        var game = new ConwaysGameOfLife(new GameUI(new TerminalUserDisplay(), new TerminalUserInput()), new GameGrid(24, 24));
        return game;
    }
}

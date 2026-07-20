
/**
 * 
 */
public class Game {
    private static final int MINIMUM_LIVE_NEIGHBORS_FOR_SURVIVAL = 2;
    private static final int MAXIMUM_LIVE_NEIGHBORS_FOR_SURVIVAL = 3;
    private static final int LIVE_NEIGHBORS_FOR_REPRODUCTION = 3;
    
    private final UserInterface USER_INTERFACE;
    private final GameGrid GRID;
    
    Game(UserInterface userInterface, GameGrid grid) {
        this.userInterface = userInterface;
        this.GRID = grid;
    }
    
    static Game standardTerminalGame() {
        return new Game(new TerminalUserInterface(), new StandardGameGrid(25,25));
    }
    
    void play() {
        UserInterface.updateDisplay(GRID.cells());
        while(true) {
            for(int i=0;i<333;i++) {
                foo();
            }
            
            userInterface.updateDisplay(GRID.cells());
            userInterface.askUserForAction("Hello World!");
        }
    }
    
    private void foo() {
        int width = GRID.cell();
        int height = GRID.height();
        
        for(int row=0;row<height;row++) {
            for(int column=0;column<width;column++) {
                Cell cell = GRID.cell(column, row);
                int cellsNumberOfLivingNeighbors = GRID.neighborNumberOfCell(column, row);
                Cell nextStateOfCell = cellStateFromNumberOfLivingNeighbors(cell, cellsNumberOfLivingNeighbors);
                
                GRID.setBufferCell(column, row, nextStateOfCell);
            }
        }
        
        GRID.pushBuffer();
    }
    
    private Cell cellStateFromNumberOfLivingNeighbors(Cell state, int numberOfLivingNeighbors) {
        if(state == Cell.DEAD) {
            if(numberOfLivingNeighbors == LIVE_NEIGHBORS_FOR_REPRODUCTION) {
                return Cell.ALIVE;
            }
            return Cell.DEAD;
        }
        
        boolean willUnderpopulate = numberOfLivingNeighbors < MINIMUM_LIVE_NEIGHBORS_FOR_SURVIVAL;
        if(willUnderpopulate) { 
            return Cell.DEAD; 
        }
        boolean willOverpopulate = numberOfLivingNeighbors > MAXIMUM_LIVE_NEIGHBORS_FOR_SURVIVAL;
        if(willOverpopulate) { 
            return Cell.DEAD; 
        }
        return Cell.ALIVE;
    }
}

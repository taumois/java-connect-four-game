
/**
 * Objects of GameGrid holds the state of every cell for a game of Conway's Game of Life. Cells are booleans, where true = alive/false = dead
 *
 * @author Isaiah Taumoepeau
 */
class GameGrid {
    private static final byte NEIGHBORS_PER_CELL = 8;
    
    private final int WIDTH;
    private final int HEIGHT;
    
    private final boolean[][] CELLS;

    /**
     * Constructor for objects of class GameGrid
     * 
     * @param width  width to make the grid
     * @param height height to make the grid
     */
    GameGrid(int width, int height) {
        this.WIDTH = width;
        this.HEIGHT = height;
        CELLS = new boolean[HEIGHT][WIDTH];
    }
    
    /**
     * Returns the state of a specified cell
     *
     * @param cellX x-coordinate of the target cell
     * @param cellY y-coordinate of the target cell
     * @return      the cell
     */
    boolean cell(int cellX, int cellY) {
        boolean cell = CELLS[cellY][cellX];
        return cell;
    }
    
    /**
     * Sets the state of a specified cell. Either alive or dead(i.e. true or false)
     *
     * @param cellX x-coordinate of the target cell
     * @param cellY y-coordinate of the target cell
     * @param state state to change the cell to
     */
    void setCellsState(int cellX, int cellY, boolean state) {
        CELLS[cellX][cellY] = state;
    }
    
    /**
     * Returns the neighbor of alive neighbors a specified cell has. A CELLS neighbors are the CELLS adjacent to it, including those diagonally adjacent
     *
     * @param  cellX x-coordinate of the target cell
     * @param  cellY y-coordinate of the target cell
     * @return the neighbors
     */
    int cellsNumberOfLivingNeighbors(int cellX, int cellY) {
        int neighbors = 0;
        
        for(int xOffset=-1;xOffset<=1;xOffset++) {
            for(int yOffset=-1;yOffset<=1;yOffset++) {
                boolean cellIsNeighbor = (xOffset != 0 || yOffset != 0);
                boolean cellIsAlive = cell(cellX+xOffset, cellY+yOffset);
                
                neighbors += (!cellIsNeighbor && cellIsAlive) ? 1 : 0;
            }
        }
        
        return neighbors;
    }
}

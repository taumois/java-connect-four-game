
/**
 * GameGrid, a class to hold the state of the game, including every cell. Cells are booleans, where true = alive/false = dead
 *
 * @author Isaiah Taumoepeau
 */
class GameGrid
{
    private static final byte NEIGHBORS_PER_CELL = 8;
    
    private final int WIDTH;
    private final int HEIGHT;
    
    private boolean[][] cells;

    /**
     * Constructor for objects of class GameGrid
     * 
     * @param  width  width to make the game grid
     * @param  height height to make the game grid
     */
    GameGrid(int width, int height)
    {
        this.WIDTH = width;
        this.HEIGHT = height;
        cells = new boolean[HEIGHT][WIDTH];
    }
    
    /**
     * Returns the state of a cell
     *
     * @param  cellX x-coordinate of the cell to return
     * @param  cellY y-coordinate of the cell to return
     * @return   the cell
     */
    boolean cell(int cellX, int cellY) {
        boolean cell = cells[cellY][cellX];
        return cell;
    }
    
    /**
     * Sets the state of a cell
     *
     * @param  cellX     x-coordinate of the cell to affect
     * @param  cellY     y-coordinate of the cell to affect
     * @param  state state to change the cell to
     */
    void setCellsState(int cellX, int cellY, boolean state) {
        cells[cellX][cellY] = state;
    }
    
    /**
     * Returns the neighbor cells of the cell at the specified index
     *
     * @param  index self explanatory
     * @return       the neighbors
     */
    int cellsNumberOfLivingNeighbors(int cellX, int cellY) {
        int neighbors = 0;
        
        for(int xOffset=-1;xOffset<=1;xOffset++) {
            for(int yOffset=-1;yOffset<=1;yOffset++) {
                if(xOffset != 0 && yOffset != 0) {
                    boolean targetNeighborAlive = cell(cellX+xOffset, cellY+yOffset);
                    neighbors += targetNeighborAlive ? 1 : 0;
                }
            }
        }
        
        return neighbors;
    }
}


/**
 * GameGrid, a class to hold the state of the game, including every cell
 *
 * @author Isaiah Taumoepeau
 */
public class GameGrid
{
    private final int WIDTH;
    private final int HEIGHT;
    
    private boolean cells[];

    /**
     * Constructor for objects of class GameGrid
     */
    public GameGrid(int width, int height)
    {
        this.WIDTH = width;
        this.HEIGHT = height;
        cells = new boolean[WIDTH * HEIGHT];
    }
    
    public boolean cell(int x, int y) {
        int cellIndex = cellIndexFromCoordinate(x, y);
        boolean cell = cells[cellIndex];
        return cell;
    }
    
    private int cellIndexFromCoordinate(int x, int y) {
        int index = y * WIDTH + x;
        return index;
    }
}

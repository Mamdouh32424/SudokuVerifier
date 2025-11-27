import java.util.ArrayList;
import java.util.List;

// array[y][x] ... for anyone reading this, to not get confused
// we start the grid at 0,0

public abstract class GridElement {

    protected int[][] grid = new int[9][9];
    protected int rowNumber;
    protected int columnNumber;
    protected int boxNumber;
    protected StringBuilder[] locations = new StringBuilder[10];

    // locations is an array that, for all numbers, would have a string of all the indices of its occurrence
    // Since the indices are 1-9 (i.e. one digit):
    // we could use the .length() to get the number of occurrences
    // we could use the .split() when printing, to eliminate other iterations of the row

    public GridElement(int[][] grid,int elementNumber) {
        this.grid = grid;
        for(int i = 0; i < 10; i++){
            locations[i] = new StringBuilder();
        }
        this.rowNumber = elementNumber;
        this.columnNumber = elementNumber;
        this.boxNumber = elementNumber;
    }

    abstract public boolean scan();

    abstract public void printError();




}

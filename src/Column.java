public class Column extends GridElement{

    public  Column(int[][] grid, int columnNumber) {
        super(grid, columnNumber,Type.COL);
    }
    public boolean scan(){
        for(int i = 0 ; i < 9 ;i++){
            locations[grid[i][columnNumber]].append(Integer.toString(i+1));
            status &= locations[grid[i][columnNumber]].length() == 1;
        }
        return status;
    }

}

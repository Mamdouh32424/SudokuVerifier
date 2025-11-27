public class Column extends GridElement{
    private int columnNumber;

    public  Column(int[][] grid, int columnNumber) {
        super(grid, columnNumber);
    }
    public boolean scan(){
        boolean flag = true;
        for(int i = 0 ; i < 9 ;i++){
            locations[grid[i][columnNumber]].append(Integer.toString(i+1));
            flag &= locations[grid[i][columnNumber]].length() == 1;
        }
        return flag;
    }

    public void printError(){
        for(int i = 1;i <= 9;i++){
            if(locations[i].length() > 1) {
                System.out.println("COL " + Integer.toString(columnNumber + 1) + ", #" + Integer.toString(i) + " [" + String.join(",", locations[i].toString().split(",")) + "]");
            }
        }
    }
}

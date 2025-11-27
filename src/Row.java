import java.util.ArrayList;
import java.util.List;

public class Row extends GridElement{

    private int rowNumber;

    public  Row(int[][] grid, int rowNumber) {
        super(grid, rowNumber);
    }


    public boolean scan(){
        boolean flag = true;
        for(int i = 0 ; i < 9 ;i++){
            locations[grid[rowNumber][i]].append(Integer.toString(i+1));
            flag &= locations[grid[rowNumber][i]].length() == 1;
        }
        return flag;
    }

    public void printError(){
        for(int i = 1;i <= 9;i++){
            if(locations[i].length() > 1) {
                System.out.println("ROW " + Integer.toString(rowNumber + 1) + ", #" + Integer.toString(i) + " [" + String.join(",", locations[i].toString().split(",")) + "]");
            }
        }
    }



}

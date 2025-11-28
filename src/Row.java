import java.util.ArrayList;
import java.util.List;

public class Row extends GridElement{

    public  Row(int[][] grid, int rowNumber) {
        super(grid, rowNumber,Type.ROW);
    }


    public boolean scan(){
        boolean flag = true;
        for(int i = 0 ; i < 9 ;i++){
            locations[grid[rowNumber][i]].append(Integer.toString(i+1));
            flag &= locations[grid[rowNumber][i]].length() == 1;
        }
        return flag;
    }

}

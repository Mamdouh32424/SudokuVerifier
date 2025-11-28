//indices of the boxes
// 0 -> 00
// 1 -> 03
// 2 -> 06
// 3 -> 30
// 4 -> 33
// 5 -> 36
// 6 -> 60
// 7 -> 63
// 8 -> 66
// n -> ((n/3) * 3) ((n%3)*3)


import javax.swing.*;

public class Box extends GridElement{

    public Box(int[][] grid,int boxNumber){
        super(grid,boxNumber,Type.BOX);
        this.rowNumber = ((boxNumber)/3) * 3;
        this.columnNumber = ((boxNumber)%3)*3;
    }

    public boolean scan(){
        boolean flag = true;
        for(int i=0 ;i < 9 ; i++){
            int x = columnNumber + (i%3);
            int y = rowNumber + (i/3);
            locations[grid[y][x]].append(Integer.toString(i+1));
            flag &= locations[grid[y][x]].length() == 1;
        }
        return flag;
    }

}

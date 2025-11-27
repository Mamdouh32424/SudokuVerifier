//indices of the boxes
// 1 -> 00
// 2 -> 03
// 3 -> 06
// 4 -> 30
// 5 -> 33
// 6 -> 36
// 7 -> 60
// 8 -> 63
// 9 -> 66
// n -> ((n-1)/3 * 3) (((n-1)%3)*3)


import javax.swing.*;

public class Box extends GridElement{

    public Box(int[][] grid,int boxNumber){
        super(grid,boxNumber);
        this.rowNumber = ((boxNumber-1)/3) * 3;
        this.columnNumber = ((boxNumber-1)%3)*3;
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

    public void printError(){
        for(int i = 1;i <= 9;i++){
            if(locations[i].length() > 1) {
                System.out.println("BOX " + Integer.toString(boxNumber + 1) + ", #" + Integer.toString(i) + " [" + String.join(",", locations[i].toString().split(",")) + "]");
            }
        }
    }

}

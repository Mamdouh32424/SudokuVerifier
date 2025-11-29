import java.util.ArrayList;
import java.util.List;

public class Row extends GridElement{

    public  Row(int rowNumber) {
        super(rowNumber,Type.ROW);
    }


    public boolean scan(){
        for(int i = 0 ; i < 9 ;i++){
            locations[grid[rowNumber][i]].append(Integer.toString(i+1));
            status &= locations[grid[rowNumber][i]].length() == 1;
        }
        return status;
    }

    @Override
    public void run() {// for the mode27
        scan();
        RowManager.setStatus(RowManager.getStatus() & this.status);
    }

}

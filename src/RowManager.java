public class RowManager extends Thread{
    private int [][] grid;
    private Row[] rows = new Row[9];
    private boolean status;
    public RowManager(int[][] grid) {
        this.grid = grid;
        status = true;
    }

    public void run27(){ // for mode27

    }

    @Override
    public void run(){ // for mode 3
        for(int i = 0; i < 9; i++){
            rows[i] = new Row(grid,i);
            status &= rows[i].scan();
        }
    }

    public void printError(){
        for(int i = 0; i < 9; i++){
            rows[i].printError();
        }
    }

    public boolean getStatus(){
        return status;
    }
}

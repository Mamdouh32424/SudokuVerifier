public class ColumnManager extends Thread{
    private  int[][] grid;
    private Column[] columns =  new Column[9];
    private boolean status;

    public ColumnManager(int[][] grid) {
        this.grid = grid;
        status = true;
    }

    @Override
    public void  run() {
        for(int i = 0; i < 9; i++){
            columns[i] = new Column(grid,i);
            status &= columns[i].scan();
        }
    }

    public void printError(){
        for(int i = 0; i < 9; i++){
            columns[i].printError();
        }
    }

    public boolean getStatus(){
        return status;
    }
}

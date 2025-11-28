public class BoxManager extends Thread{
    private int [][] grid;
    private Box[] boxes = new Box[9];
    private boolean status;
    public BoxManager(int[][] grid) {
        this.grid = grid;
        status = true;
    }

    @Override
    public void run(){
        for(int i = 0; i < 9; i++){
            boxes[i] = new Box(grid,i);
            status &= boxes[i].scan();
        }
    }

    public void printError(){
        for(int i = 0; i < 9; i++){
            boxes[i].printError();
        }
    }

    public boolean getStatus(){
        return status;
    }
}

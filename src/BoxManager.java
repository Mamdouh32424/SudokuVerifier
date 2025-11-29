public class BoxManager extends Thread{
    private int [][] grid;
    private Box[] boxes = new Box[9];
    private static boolean status;
    public BoxManager() {
        this.grid = Board.getGrid();
        status = true;
        for(int i = 0; i < 9; i++){
            boxes[i] = new Box(i);
        }
    }

    public void startBoxes(){ // for mode27
        for (int i = 0; i < 9; i++) {
            boxes[i].start();
        }
    }
    public void joinBoxes(){
        try {
            for (int i = 0; i < 9; i++) {
                boxes[i].join();
            }
        }
        catch (InterruptedException e) {
            System.err.println("ERROR " + e.getMessage());
        }
    }


    @Override
    public void run(){
        for(int i = 0; i < 9; i++){
            status &= boxes[i].scan();
        }
    }

    public void printError(){
        for(int i = 0; i < 9; i++){
            boxes[i].printError();
        }
    }

    public static synchronized boolean getStatus(){
        return status;
    }
    public static synchronized void setStatus(boolean status){
        BoxManager.status = status;
    }
}

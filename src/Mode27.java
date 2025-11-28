public class Mode27 {
    private static boolean status;
    private int[][] grid;

    private Row[] rows = new Row[9];
    private Column[] columns = new Column[9];
    private Box[] boxes = new Box[9];

    public Mode27(int[][] grid) {
        this.grid = grid;

        for(int i = 0; i < 9; i++){
            rows[i] = new Row(grid,i);
            columns[i] = new Column(grid,i);
            boxes[i] = new Box(grid,i);
        }
        status = true;
    }

    public void run() {
        try {
            for (int i = 0; i < 9; i++) {
                rows[i].start();
                columns[i].start();
                boxes[i].start();
            }
            for (int i = 0; i < 9; i++) {
                rows[i].join();
                columns[i].join();
                boxes[i].join();
            }

            if(getStatus()) {
                System.out.println("Valid");
            }
            else {
                System.out.println("Invalid");
                printRowErrors();
                System.out.println("------------------------------------------");
                printColumnErrors();
                System.out.println("------------------------------------------");
                printBoxErrors();
            }
        }
        catch (InterruptedException e) {
            System.err.println("ERROR: " + e.getMessage());
        }
    }

    public void printRowErrors(){
        for(int i = 0;i<9;i++) {
            rows[i].printError();
        }
    }
    public void printColumnErrors(){
        for(int i = 0;i<9;i++) {
            columns[i].printError();
        }
    }
    public void printBoxErrors(){
        for(int i = 0;i<9;i++) {
            boxes[i].printError();
        }
    }

    public static synchronized boolean getStatus(){
        return status;
    }
    public static synchronized void setStatus(boolean status){
        Mode27.status = status;
    }
}

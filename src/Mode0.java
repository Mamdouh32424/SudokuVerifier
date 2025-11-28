public class Mode0 {

    private int [][] grid;

    private Row[] rows = new Row[9];
    private Column[] columns = new Column[9];
    private Box[] boxes = new Box[9];

    public Mode0(int[][] grid) {
        this.grid = grid;

        for(int i = 0; i < 9; i++){
            rows[i] = new Row(grid,i);
            columns[i] = new Column(grid,i);
            boxes[i] = new Box(grid,i);
        }

    }

    public void run() {
        boolean valid = true;
        valid &= scanRows();
        valid &= scanColumns();
        valid &= scanBoxes();

        if(valid){
            System.out.println("Valid");
        }
        else{
            System.out.println("Invalid");
            printRowErrors();
            System.out.println("------------------------------------------");
            printColumnErrors();
            System.out.println("------------------------------------------");
            printBoxErrors();
        }
    }


    public boolean scanRows(){
        boolean valid = true;
        for(int i = 0;i<9;i++) {
            valid &= rows[i].scan();
        }
        return valid;
    }
    public boolean scanColumns(){
        boolean valid = true;
        for(int i = 0;i<9;i++) {
            valid &= columns[i].scan();
        }
        return valid;
    }
    public boolean scanBoxes(){
        boolean valid = true;
        for(int i = 0;i<9;i++) {
            valid &= boxes[i].scan();
        }
        return valid;
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
}

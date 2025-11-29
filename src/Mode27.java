public class Mode27 {
    private int[][] grid;

    private RowManager rowManager;
    private ColumnManager columnManager;
    private BoxManager boxManager;

    public Mode27() {
        this.grid = Board.getGrid();


        rowManager = new RowManager();
        columnManager = new ColumnManager();
        boxManager = new BoxManager();
    }

    public void run() {
        rowManager.startRows();
        columnManager.startColumns();
        boxManager.startBoxes();

        rowManager.joinRows();
        columnManager.joinColumns();
        boxManager.joinBoxes();

        if(rowManager.getStatus() && columnManager.getStatus() && boxManager.getStatus()) {
            System.out.println("Valid");
        }
        else {
            System.out.println("Invalid");
            rowManager.printError();
            System.out.println("------------------------------------------");
            columnManager.printError();
            System.out.println("------------------------------------------");
            boxManager.printError();
        }
    }
}

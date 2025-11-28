public class Mode3{
    private int[][] grid;
    private RowManager rowManager;
    private ColumnManager columnManager;
    private BoxManager boxManager;

    public Mode3(int[][] grid) {
        this.grid = grid;
        this.rowManager = new RowManager(grid);
        this.columnManager = new ColumnManager(grid);
        this.boxManager = new BoxManager(grid);
    }

    public void run() {
        rowManager.start();
        columnManager.start();
        boxManager.start();
        try {
            rowManager.join();
            columnManager.join();
            boxManager.join();

            if (rowManager.getStatus() && columnManager.getStatus() && boxManager.getStatus()) {
                System.out.println("Valid");
            } else {
                System.out.println("Invalid");
                rowManager.printError();
                System.out.println("------------------------------------------");
                columnManager.printError();
                System.out.println("------------------------------------------");
                boxManager.printError();
            }
        }
        catch (InterruptedException e) {
            System.err.println("ERROR " + e.getMessage());
        }
    }
}

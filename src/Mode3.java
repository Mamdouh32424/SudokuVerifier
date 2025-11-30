public class Mode3 {
    private RowManager rowManager;
    private ColumnManager columnManager;
    private BoxManager boxManager;

    public Mode3() {
        this.rowManager = new RowManager();
        this.columnManager = new ColumnManager();
        this.boxManager = new BoxManager();
    }

    public void run() {
        rowManager.start();
        columnManager.start();
        boxManager.start();
        try {
            rowManager.join();
            columnManager.join();
            boxManager.join();

            if (RowManager.getStatus() && ColumnManager.getStatus() && BoxManager.getStatus()) {
                System.out.println("Valid");
            } else {
                System.out.println("Invalid");
                rowManager.printError();
                System.out.println("------------------------------------------");
                columnManager.printError();
                System.out.println("------------------------------------------");
                boxManager.printError();
            }
        } catch (InterruptedException e) {
            System.err.println("ERROR " + e.getMessage());
        }
    }
}
public class Mode0 {
    private RowManager rowManager;
    private ColumnManager columnManager;
    private BoxManager boxManager;

    public Mode0() {
        this.rowManager = new RowManager();
        this.columnManager = new ColumnManager();
        this.boxManager = new BoxManager();
    }

    public void run() {
        rowManager.run(); // don't call start(), so that it runs on the same thread
        columnManager.run();
        boxManager.run();

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
    }
}
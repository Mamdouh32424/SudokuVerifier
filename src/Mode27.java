public class Mode27 {
    private RowManager rowManager;
    private ColumnManager columnManager;
    private BoxManager boxManager;

    public Mode27() {
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
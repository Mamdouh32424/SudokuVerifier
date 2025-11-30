public class ColumnManager extends Thread {
    private Column[] columns = new Column[9];
    private static boolean status;

    public ColumnManager() {
        status = true;
        for (int i = 0; i < 9; i++) {
            columns[i] = new Column(i);
        }
    }

    public void startColumns() { // for mode27
        for (int i = 0; i < 9; i++) {
            columns[i].start();
        }
    }

    public void joinColumns() {
        try {
            for (int i = 0; i < 9; i++) {
                columns[i].join();
            }
        } catch (InterruptedException e) {
            System.err.println("ERROR " + e.getMessage());
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 9; i++) {
            status &= columns[i].scan();
        }
    }

    public void printError() {
        for (int i = 0; i < 9; i++) {
            columns[i].printError();
        }
    }

    public static synchronized boolean getStatus() {
        return status;
    }

    public static synchronized void setStatus(boolean status) {
        ColumnManager.status = status;
    }
}
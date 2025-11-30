public class RowManager extends Thread {
    private Row[] rows = new Row[9];
    private static boolean status;

    public RowManager() {
        status = true;
        for (int i = 0; i < 9; i++) {
            rows[i] = new Row(i);
        }
    }

    public void startRows() { // for mode27, start each grid element as its own thread
        for (int i = 0; i < 9; i++) {
            rows[i].start();
        }
    }

    public void joinRows() {
        try {
            for (int i = 0; i < 9; i++) {
                rows[i].join();
            }
        } catch (InterruptedException e) {
            System.err.println("ERROR " + e.getMessage());
        }
    }

    @Override
    public void run() { // for mode 3 and 0
        for (int i = 0; i < 9; i++) {
            status &= rows[i].scan();
        }
    }

    public void printError() {
        for (int i = 0; i < 9; i++) {
            rows[i].printError();
        }
    }

    public static synchronized boolean getStatus() {
        return status;
    }

    public static synchronized void setStatus(boolean status) {
        RowManager.status = status;
    }
}
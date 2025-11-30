public class Main {
        public static void main(String[] args) {
                if (args.length != 2) {
                        System.err.println("Usage: java -jar <app-name>.jar <csv-filepath> <mode>");
                        return;
                }

                String filepath = args[0];
                int mode;
                try {
                        mode = Integer.parseInt(args[1]);
                } catch (NumberFormatException e) {
                        System.err.println("Error: Mode must be an integer (0, 3, or 27)");
                        return;
                }

                Board.readFromFile(filepath);
                try {
                        Object modeInstance = Mode.createMode(mode);

                        if (modeInstance instanceof Mode0) {
                                ((Mode0) modeInstance).run();
                        } else if (modeInstance instanceof Mode3) {
                                ((Mode3) modeInstance).run();
                        } else if (modeInstance instanceof Mode27) {
                                ((Mode27) modeInstance).run();
                        }
                } catch (IllegalArgumentException e) {
                        System.err.println("Error: " + e.getMessage());
                        return;
                }
        }
}
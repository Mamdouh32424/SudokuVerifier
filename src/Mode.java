public class Mode {
    public static Object createMode(int mode) {
        switch(mode) {
            case 0:
                return new Mode0();
            case 3:
                return new Mode3();
            case 27:
                return new Mode27();
            default:
                throw new IllegalArgumentException("Invalid mode: " + mode + ". Use 0, 3, or 27.");
        }
    }
}
import java.io.*;
import java.nio.file.*;
import java.util.Set;

public class Main {
    public static int[][] grid;
    
    public static void main(String[] args) {
        String file = "src/Data1.csv";
        Board.readFromFile(file);

//        long startTime = System.currentTimeMillis();
//        System.out.println(startTime);
        Mode0 mode0 = new Mode0(Board.getGrid());
        mode0.run();
        System.out.println();
//        System.out.println(System.currentTimeMillis() - startTime);
//        startTime = System.currentTimeMillis();
        Mode3 mode3 = new Mode3(Board.getGrid());
        mode3.run();
        System.out.println();
//        System.out.println( System.currentTimeMillis() - startTime);
//        startTime = System.currentTimeMillis();
        Mode27 mode27 = new Mode27(Board.getGrid());
        mode27.run();
//        System.out.println( System.currentTimeMillis() - startTime);
    }
}
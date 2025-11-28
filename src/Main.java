import java.io.*;
import java.nio.file.*;
import java.util.Set;

public class Main {
    public static int[][] grid;


    public static void readFromFile(String fileName) {
        grid = new int[9][9];
        Path p = Paths.get(fileName);
        if (!Files.exists(p))
            return;
        try (BufferedReader br = Files.newBufferedReader(p)) {
            String line;
            int i=0;
            while ((line = br.readLine()) != null) {
                String[] split = line.split(",");
                for(int j=0;j<9;j++){
                    grid[i][j] = Integer.parseInt(split[j]);
                }
                i++;
            }
        } catch (IOException e) {
            System.err.println("Error reading " + fileName + ": " + e.getMessage());
        }
        return;
    }
    
    public static void main(String[] args) {
        String file = "src/Data1.csv";
        readFromFile(file);

//        long startTime = System.currentTimeMillis();
//        System.out.println(startTime);
        Mode0 mode0 = new Mode0(grid);
        mode0.run();
        System.out.println();
//        System.out.println(System.currentTimeMillis() - startTime);
//        startTime = System.currentTimeMillis();
        Mode3 mode3 = new Mode3(grid);
        mode3.run();
        System.out.println();
//        System.out.println( System.currentTimeMillis() - startTime);
//        startTime = System.currentTimeMillis();
        Mode27 mode27 = new Mode27(grid);
        mode27.run();
//        System.out.println( System.currentTimeMillis() - startTime);
    }
}
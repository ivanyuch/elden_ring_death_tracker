import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DeathCounter {
    public static void main(String[] args) {
      try (BufferedReader reader = new BufferedReader(new FileReader("deaths.txt"))) {
        String line = reader.readLine();
        String[] parts = line.split(",");
        int margit = Integer.parseInt(parts[0]);
        int godrick = Integer.parseInt(parts[1]);
        int wolf = Integer.parseInt(parts[2]);
        int rennala = Integer.parseInt(parts[3]);
        int radahn = Integer.parseInt(parts[4]);
        int rykard = Integer.parseInt(parts[5]);
        int shade = Integer.parseInt(parts[6]);
        int morgott = Integer.parseInt(parts[7]);
        int giant = Integer.parseInt(parts[8]);
        int duo = Integer.parseInt(parts[9]);
        int maliketh = Integer.parseInt(parts[10]);
        int gideon = Integer.parseInt(parts[11]);
        int godfrey = Integer.parseInt(parts[12]);
        int radagon = Integer.parseInt(parts[13]);

      } catch (IOException e) {
        System.err.println("Error reading the file: " + e.getMessage());
      }
    }
  
}

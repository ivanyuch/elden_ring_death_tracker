import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class DeathCounter {
  public static void main(String[] args) {
    // Accesses the deaths.txt file and reads the boss information
    try (BufferedReader reader = new BufferedReader(new FileReader("deaths.txt"))) {
      // Initialize a map to store boss information
      Map <String, BossInfo> bossMap = new HashMap<>();

      // Reads each line in the file, records in map. Expects 14 lines of data
      for (int i = 0; i < 14; i++) {
        String line = reader.readLine();
        if (line == null) {
          System.err.println("Error: Not enough data in the file.");
          return;
        }
        String[] parts = line.split(";");
        BossInfo bossInfo = new BossInfo(parts[0], Boolean.parseBoolean(parts[1]), Integer.parseInt(parts[2]));
        bossMap.put(parts[3], bossInfo);
      }

    } catch (IOException e) {
      System.err.println("Error reading the file: " + e.getMessage());
    }

    boolean happenedOnce = true;
    Scanner scanner = new Scanner(System.in);

    while (true) {
      // Display the welcome message one time only
      while (happenedOnce) {
        System.out.println("Welcome to the Elden Ring Death Counter!");
        System.out.println("Please select a command:");
        happenedOnce = false;
      }
      printCommands();
      String command = scanner.nextLine().trim().toLowerCase();
      switch (command) {
        // case "show":
        //   commandShow();
        //   break;
        // case "select":
        //   commandSelect();
        //   break;
        // case "help":
        //   commandHelp();
        //   break;
        case "exit":
          commandExit();
          scanner.close();
          break;
        default:
          System.out.println("\nUnknown command. Please select from listed commands:");
      }

    }
  }

  public static void printCommands () {
    System.out.println("'Show' Show all deaths");
    System.out.println("'Select' select a boss to track");
    System.out.println("'Help' provides more information about the commands");
    System.out.println("'Exit' exit the program");
    System.out.print("\nEnter command: ");
  }

  public static void commandExit() {
    System.out.println("Exiting the program...");
    System.exit(0);
  }
  
}

class BossInfo {
  private String name;
  private boolean activated;
  private int deaths;

  public BossInfo(String name, boolean activated, int deaths) {
    this.name = name;
    this.activated = activated;
    this.deaths = deaths;
  }

  public String getName() {
    return name;
  }

  public boolean getActivated() {
    return activated;
  }

  public int getDeaths() {
    return deaths;
  }

  public int addDeath() {
    return ++deaths;
  }

  public void setDeaths(int deaths) {
    this.deaths = deaths;
  }

  public void setActivated(boolean activated) {
    this.activated = activated;
  }

  @Override
  public String toString() {
    return name + ": " + deaths + " deaths";
  }
}

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

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

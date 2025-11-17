import java.util.ArrayList; // Used to store drivers and races 
import java.util.Scanner; // Used for user input
import java.util.HashMap; // Used as a dictionary

public class DriverNames
{
    // Setup global variables
    static ArrayList<String> drivers = new ArrayList<String>(); // Setup array for driver names which are used globally
    static ArrayList<String> races = new ArrayList<String>(); // Setup array for race names which are used globally
    static HashMap<String, Integer> championshipPoints = new HashMap<String, Integer>(); // Used to store the championship points
    static HashMap<String, String> raceWinners = new HashMap<String, String>(); // Used to store who won each race
    static Scanner scanner = new Scanner(System.in); // Used for user input
    static String userName = ""; // Used to get and store the user's name to make it personalised
    public static void main(String[] args)
    {
        System.out.println("Hello World");
    }
}
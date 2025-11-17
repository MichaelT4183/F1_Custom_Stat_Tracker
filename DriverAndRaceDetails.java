import java.util.ArrayList; // Used to store drivers and races 
import java.util.Scanner; // Used for user input
import java.util.HashMap; // Used as a dictionary

public class DriverAndRaceDetails
{
    // Setup global variables
    static ArrayList<String> drivers = new ArrayList<String>(); // Setup array for driver names which are used globally
    static ArrayList<String> races = new ArrayList<String>(); // Setup array for race names which are used globally
    static HashMap<String, Integer> championshipPoints = new HashMap<String, Integer>(); // Used to store the championship points
    static HashMap<String, String> raceWinners = new HashMap<String, String>(); // Used to store who won each race
    static Scanner scanner = new Scanner(System.in); // Used for user input
    static String userName = ""; // Used to get and store the user's name to make it personalised
    
    // Method used to get the names of the drivers
    public void driverNames()
    {
        String name = "";
        System.out.println(userName+", please input the names of the drivers. Type 'stop' to end:");

        // Allow the user the keep adding names until they type 'stop'
        while(!name.equals("stop"))
        {
            name = scanner.nextLine();
            // Stops the while loop when the user inputs 'stop'
            if(name.equals("stop"))
            {
                break;
            }
            drivers.add(name); // Add the name to the ArrayList
        }
    }

    // Method used to get the names of the races
    public void raceNames()
    {
        String race = "";
        System.out.println("\n"+userName+", please input the names of the races. Type 'stop' to end:");

        // Allow the user the keep adding names until they type 'stop'
        while(!race.equals("stop"))
        {
            race = scanner.nextLine();
            // Stops the while loop when the user inputs 'stop'
            if(race.equals("stop"))
            {
                break;
            }
            races.add(race); // Add the race to the ArrayList
        }
    }
}
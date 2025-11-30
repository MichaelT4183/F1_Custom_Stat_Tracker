// Import methods from custom packages
import packages.seasonMethods.DriverAndRaceDetails;
import packages.seasonMethods.RaceSimulator;
import java.util.Scanner; // Used for user input
import java.util.ArrayList; // Used to store the drivers and the races

public class MainClass
{
    public static void main(String[] args)
    {
        // Get the user's name before the program fully starts
        System.out.println("Welcome user! Before we start, we will need your name.");
        String userName = getUserName();
        // Welcome message to introduce the user to the program
        System.out.println("\nHello "+userName+" and welcome to the Custom F1 Season Simulator!");
        System.out.println("\nBefore you are able to start simulating your own custom F1 races, you need to give us your drivers and races.");

        // Get the drivers and the races in the season and display them
        DriverAndRaceDetails driversAndRaces = new DriverAndRaceDetails(userName);
        ArrayList<String> drivers = driversAndRaces.getDriverNames();
        ArrayList<String> races = driversAndRaces.getRaceNames();
        System.out.println(driversAndRaces);

        // Simulate the races
        RaceSimulator simRace = new RaceSimulator(drivers, races);
        for(int i = 0; i < races.size(); i++)
        {
            simRace.simulateRace(i);
        }
    }

    // Method to get the name of the user
    private static String getUserName()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your name:");
        String userName = scanner.nextLine();

        return userName;
    }
}
// Import methods from custom packages
import packages.seasonMethods.DriverAndRaceDetails;
import packages.seasonMethods.RaceSimulator;
import java.util.Scanner; // Used for user input
import java.util.ArrayList; // Used to store the drivers and the races

/* This class is designed to be the main program that is ran for the user to
use the custom F1 season simulator. This file uses code from the test files
as they show that the code works and does not produce errors. When a user
is using the program, this is the file that uses all the package methods
and classes */
public class MainClass
{
    public static void main(String[] args)
    {
        // Get the user's name before the program fully starts
        System.out.println("Welcome user! Before we start, we will need your name.");
        Scanner scanner = new Scanner(System.in);
        String userName = getUserName(scanner);
        // Welcome message to introduce the user to the program
        System.out.println("\nHello "+userName+" and welcome to the Custom F1 Season Simulator!");
        System.out.println("\nBefore you are able to start simulating your own custom F1 races, you need to give us your drivers and races.");

        // Get the drivers and the races in the season and display them
        DriverAndRaceDetails driversAndRaces = new DriverAndRaceDetails(userName);
        ArrayList<String> drivers = driversAndRaces.getDriverNames();
        ArrayList<String> races = driversAndRaces.getRaceNames();
        System.out.println(driversAndRaces);

        /* Menu for the season simulator to give users a choice on what to do.
        This will end either when the user closes the program or when the program runs
        out of races */
        RaceSimulator simRace = new RaceSimulator(drivers, races);
        int userInput;
        int i = 0;
        while(i < races.size())
        {
            System.out.println("\nPlease choose from one of the following options\n");
            System.out.println("1) See drivers and races");
            System.out.println("2) Simulate the next race in the season");
            System.out.println("3) View the championship table");
            System.out.println("4) End the program");
            userInput = scanner.nextInt();

            if(userInput == 1)
            {
                // Display the drivers and races
                System.out.println(driversAndRaces);
            }
            else if(userInput == 2)
            {
                // Simulate a race
                simRace.simulateRace(i);
                i++;
            }
            else if(userInput == 3)
            {
                // Display the championship table
                simRace.displayChampionshipTable();
            }
            else if(userInput == 4)
            {
                // Ends the program
                System.out.println("\nThank you for using this simulator");
                System.out.println("A file has been created to store all of the season information");
                System.exit(0);
            }
            else
            {
                System.out.println("That was an incorrect input. Please try again.");
                userInput = scanner.nextInt();
            }
        }
        // Goodbye message when the season has been fully simulated
        System.out.println("\nAll of the races have been simulated\n");
        System.out.println("\nThank you for using this simulator");
        System.out.println("A file has been created to store all of the season information");
        System.exit(0);
    }

    // Method to get the name of the user
    private static String getUserName(Scanner scanner)
    {
        System.out.println("Please enter your name:");
        String userName = scanner.nextLine();

        return userName;
    }
}
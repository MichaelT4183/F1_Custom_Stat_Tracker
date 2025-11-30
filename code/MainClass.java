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

        // Create a menu for the season simulator to give users a choice on what to do
        RaceSimulator simRace = new RaceSimulator(drivers, races);
        int userInput;
        while(true)
        {
            System.out.println("Please choose from one of the following options\n");
            System.out.println("1) See drivers and races");
            System.out.println("2) Simulate the season");
            System.out.println("3) View the championship table");
            System.out.println("4) End the program");
            userInput = scanner.nextInt();

            if(userInput == 1)
            {
                System.out.println(driversAndRaces);
            }
            else if(userInput == 2)
            {
                // Simulate the races
                for(int i = 0; i < races.size(); i++)
                {
                    simRace.simulateRace(i);
                }
            }
            else if(userInput == 3)
            {
                simRace.displayChampionshipTable();
            }
            else if(userInput == 4)
            {
                System.out.println("\nThank you for using this simulator");
                System.exit(0);
            }
            else
            {
                System.out.println("That was an incorrect input. Please try again.");
                userInput = scanner.nextInt();
            }
        }
    }

    // Method to get the name of the user
    private static String getUserName(Scanner scanner)
    {
        System.out.println("Please enter your name:");
        String userName = scanner.nextLine();

        return userName;
    }
}
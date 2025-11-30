package packages.seasonMethods;

import java.util.Scanner; // Used for user input
import java.util.ArrayList; // Used for the driver and race lists
import java.util.Random; // Used to get the weather, tires, dnf's, AI simulations etc.

public class RaceSimulator
{
    private ArrayList<String> drivers; // Get the drivers competing in the season
    private ArrayList<String> races; // Get the number of races and the race names that are in the season
    //private ChampionshipTable championship = new ChampionshipTable(drivers);
    private Scanner scanner = new Scanner(System.in);
    private ChampionshipTable championship;

    // Create the java constructor
    public RaceSimulator(ArrayList<String> drivers, ArrayList<String> races)
    {
        // Initialize the variables
        this.drivers = drivers;
        this.races = races;
        this.championship = new ChampionshipTable(drivers);
    }

    // Method to simulate a single race
    public void simulateRace(int i)
    {
        // Get the name of the race and display the race information
        String raceName = races.get(i);
        String weather = getWeather();
        System.out.println("The next race is: "+raceName+"\n\n");
        System.out.println("Weather: "+weather);
        // Display the results of the race
        System.out.println("\n\nHere is your race result:\n\n");
        String[] raceFinish = getRaceFinish();

        // Ask the user if they are ready to continue with the next race
        System.out.println("Please type 'next' to move onto the next race");
        String userInput = scanner.nextLine();
        do
        {
            if(!userInput.equals("next"))
            {
                System.out.println("\nError: incorrect input. Please try again.");
                userInput = scanner.nextLine();
            }
            else
            {
                break;
            }
        }
        while(!userInput.equals("next"));
        // Store the race stats
        StatCounter stats = new StatCounter(drivers, races, championship);
        stats.getStats(raceName, weather, raceFinish);
    }

    // Method to get the weather for the race
    private String getWeather()
    {
        // Get a random rumber to decide the weather
        Random rng = new Random();
        int max = 10;
        int min = 1;
        int r = rng.nextInt(max - min + 1) + 1;

        // Check what number was generated (20% chance to rain)
        if(r >= 9)
        {
            String weather = "Wet";
            return weather;
        }
        else
        {
            String weather = "Dry";
            return weather;
        }
    }

    // Method to get the race finish
    private String[] getRaceFinish()
    {
        String raceFinish[] = new String [drivers.size()]; // Create an array for where the drivers finish the race (length based on number of drivers)
        ArrayList<String> driverListCopy = new ArrayList<>(drivers); // Used to make sure to not delete the original driver list
        // Get a new random runber to randomly decide who wins
        Random rng = new Random();
        int max = driverListCopy.size();
        int min = 0;
        // Loop through all of the drivers randomly
        for(int i = 0; i < drivers.size(); i++)
        {
            int r = rng.nextInt(max - min);
            String driverName = driverListCopy.get(r); // Get the driver's name
            raceFinish[i] =  driverName; // Add the driver to the race finish array
            max -= 1; // Reduce the range of the rng
            driverListCopy.remove(driverName); // Remove the driver from the list
        }
        
        displayRaceFinish(raceFinish); // Display the race finish
        
        championship.appendChampionshipTable(raceFinish); // Sends the race finish to ChampionshipTable.java to append the table
        System.out.println(championship);

        return raceFinish;
    }

    // Method to display the race finish
    private void displayRaceFinish(String[] raceFinish)
    {
        for(int i = 0; i < raceFinish.length; i++)
        {
            System.out.println((i+1)+". "+raceFinish[i]);
        }
    }
}

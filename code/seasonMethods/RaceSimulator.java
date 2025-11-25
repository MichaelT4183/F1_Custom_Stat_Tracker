import java.util.Scanner; // Used for user input
import java.util.ArrayList; // Used for the driver and race lists
import java.util.Random; // Used to get the weather, tires, dnf's, AI simulations etc.

public class RaceSimulator
{
    private ArrayList<String> drivers; // Get the drivers competing in the season
    private ArrayList<String> races; // Get the number of races and the race names that are in the season
    private String raceFinish[] = new String [drivers.size()]; // Create an array for where the drivers finish the race (length based on number of drivers)
    private Scanner scanner = new Scanner(System.in);

    // Create the java constructor
    public RaceSimulator(ArrayList<String> drivers, ArrayList<String> races)
    {
        // Initialize the variables
        this.drivers = drivers;
        this.races = races;
    }

    // Method used to simulate the whole season
    public void simulateSeason()
    {
        // Get the number of races in the season
        final int numOfRaces = races.size(); 
        // 'For loop' to loop through the races and count up until there are no races left
        for(int i = 0; i < numOfRaces; i++)
        {
            simulateRace(i);
        }
    }

    // Method to simulate a single race
    private void simulateRace(int i)
    {
        // Get the name of the race and display the race information
        String raceName = races.get(i);
        String weather = getWeather();

        System.out.println("The next race is: "+raceName+"\n\n");
        System.out.println("Here is a reminder of your drivers:\n "+drivers);
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
        if(r == 9 || r == 10)
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
}

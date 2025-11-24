import java.util.ArrayList; // Used for the driver and race lists

public class RaceSimulator
{
    private ArrayList<String> drivers; // Get the drivers competing in the season
    private ArrayList<String> races; // Get the number of races and the race names that are in the season
    private String raceFinish[] = new String [drivers.size()]; // Create an array for where the drivers finish the race (length based on number of drivers)

    // Create the java constructor
    public RaceSimulator(ArrayList<String> drivers, ArrayList<String> races)
    {
        // Initialize the variables
        this.drivers = drivers;
        this.races = races;
    }

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

    private void simulateRace(int i)
    {

    }
}

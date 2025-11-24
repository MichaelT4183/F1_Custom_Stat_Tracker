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
        String raceName = races.get(i); // Get the name of the race
        System.out.println("The next race is: "+raceName+"\n\n");
        // Ask the user if they want to decide the race finish or if they want an AI (RNG) to simulate
        System.out.println("Would you like to decide the race finish or have it simulated for you?\nPlease type either y/n");
        String userAnswer = scanner.nextLine();
        do // Do-While loop to throw an error when the user does not input a valid answer
        {
            if (userAnswer.equals("y"))
            {
                System.out.println("\nYou have chosen to decide the race finish yourself.\n\n");
                userRaceSimulator();
                break;
            }
            else if (userAnswer.equals("n"))
            {
                System.out.println("\nYou have chosen to have the race simulated for you.\n\n");
                aiRaceSimulator();
                break;
            }
            // Error message when the user does not input the correct message and asks for a new input
            else 
            {
                System.out.println("Error: try again");
                userAnswer = scanner.nextLine();
            }
        }
        while(!userAnswer.equals("y") || !userAnswer.equals("n"));
    }

    private void userRaceSimulator(int i)
    {
        // Get the name of the race and display the race information
        String raceName = races.get(i);
        System.out.println("The next race is: "+raceName+"\n\n");
        System.out.println("Here is a reminder of your drivers:\n "+drivers);

        // Get the details of the race
        getRaceDetails();

    }

    private void aiRaceSimulator()
    {

    }

    private void getRaceDetails()
    {

    }
}

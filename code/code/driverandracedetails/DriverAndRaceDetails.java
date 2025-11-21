package code.driverandracedetails;

import java.util.ArrayList; // Used to store drivers and races 
import java.util.Scanner; // Used for user input

public class DriverAndRaceDetails
{
    // Setup global variables
    private ArrayList<String> drivers = new ArrayList<>(); // Initialise array for driver names
    private ArrayList<String> races = new ArrayList<>(); // Initialise array for race names
    private String userName; // Used to get and store the user's name to make it personalised
    Scanner scanner = new Scanner(System.in); // Used for user input
    
    // Create the Java constructor
    public DriverAndRaceDetails(String userName)
    {
        this.userName = userName;
    }

    // Method used to get the names of the drivers
    public void getDriverNames()
    {
        String driverName = "";
        System.out.println(userName+", please input the names of the drivers. Type 'stop' to end:");

        // Allow the user the keep adding names until they type 'stop'
        while(!driverName.equals("stop"))
        {
            driverName = scanner.nextLine();
            // Stops the while loop when the user inputs 'stop'
            if(driverName.equals("stop"))
            {
                break;
            }
            drivers.add(driverName); // Add the name to the ArrayList
        }
    }

    // Method used to get the names of the races
    public void getRaceNames()
    {
        String raceName = "";
        System.out.println("\n"+userName+", please input the names of the races. Type 'stop' to end:");

        // Allow the user the keep adding names until they type 'stop'
        while(!raceName.equals("stop"))
        {
            raceName = scanner.nextLine();
            // Stops the while loop when the user inputs 'stop'
            if(raceName.equals("stop"))
            {
                break;
            }
            races.add(raceName); // Add the race to the ArrayList
        }
    }

    // toString method to display the list of drivers and races
    public String toString()
    {
        return "Your drivers are: "+drivers+"\n\nYour races are: "+races;
    }
}
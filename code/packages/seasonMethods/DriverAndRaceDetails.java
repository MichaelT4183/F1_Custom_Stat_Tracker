package packages.seasonMethods; // Package the class into a general folder for testing and MainClass

import java.util.ArrayList; // Used to store drivers and races 
import java.util.Scanner; // Used for user input

/* This class is designed to get the users to input the names of
the drivers that will be taking part and the races that they are
competing in. This program will store them into an ArrayList and
will be used in different files. */
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
        this.userName = userName; // Initialize the variable into the file
    }

    // Method used to get the names of the drivers
    public ArrayList<String> getDriverNames()
    {
        String driverName = ""; // Store as a blank so the loop can continue
        System.out.println(userName+", please input the names of the drivers. Type 'stop' to end:");

        // Allow the user the keep adding names until they type 'stop'
        while(!driverName.equals("stop"))
        {
            driverName = scanner.nextLine();
            // Checks if the user has inputted anything
            if(driverName == null || driverName.isEmpty())
            {
                System.out.println("Please enter a value\n"); // Throws an error
            }
            else
            {
                // Stops the while loop when the user inputs 'stop'
                if(driverName.equals("stop"))
                {
                    break;
                }
                else
                {
                    drivers.add(driverName); // Add the name to the ArrayList
                }
            }
        }

        return drivers;
    }

    // Method used to get the names of the races
    public ArrayList<String> getRaceNames()
    {
        String raceName = ""; // Store as a blank so the loop can continue
        System.out.println("\n"+userName+", please input the names of the races. Type 'stop' to end:");

        // Allow the user the keep adding names until they type 'stop'
        while(!raceName.equals("stop"))
        {
            raceName = scanner.nextLine();
            // Checks if the user has inputted anything
            if(raceName == null || raceName.isEmpty())
            {
                System.out.println("Please enter a value\n"); // Throws an error
            }
            else
            {
                // Stops the while loop when the user inputs 'stop'
                if(raceName.equals("stop"))
                {
                    break;
                }
                else
                {
                    races.add(raceName); // Add the name to the ArrayList
                }
            }
        }

        return races;
    }

    // toString method to display the list of drivers and races
    public String toString()
    {
        return "\nYour drivers are: "+drivers+"\n\nYour races are: "+races;
    }
}
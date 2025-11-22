import java.util.ArrayList; // Used for the test list of drivers
import seasonMethods.ChampionshipTable; // Import the package for testing

public class Test_File_ChampionshipTable
{
    // Main method used for testing
    public static void main(String[] args) 
    {
        ArrayList<String> drivers = new ArrayList<>(); // ArrayList for test data (Driver names)
        // Populate the driver's ArrayList for test data
        drivers.add("Lando");
        drivers.add("Charles");
        drivers.add("Max");

        // Test the constructor
        ChampionshipTable table = new ChampionshipTable(drivers);

        // Test to try and print the championship table before populating it (Should return an error)
        System.out.println(table);

        // Create the race finish and attempt to append the championship table
        String raceFinish[] = {"Lando", "Max", "Charles"}; // Array for test data (Race finish)
        table.appendChampionshipTable(raceFinish);

        // Check to see if the championship table has been altered
        System.out.println(table);

        // Create a 2nd race finish and attempt to append the championship table again
        String raceFinish2[] = {"Max", "Charles", "Lando"}; // Array for test data (Race finish)
        table.appendChampionshipTable(raceFinish2);

        // Check to see if the championship table has been altered
        System.out.println(table);
    }
}
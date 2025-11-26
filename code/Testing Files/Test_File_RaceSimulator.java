import packages.seasonMethods.RaceSimulator;
import java.util.ArrayList;

public class Test_File_RaceSimulator
{
    // Main method to run the test file
    public static void main(String[] args)
    {
        // Create test data variables
        ArrayList<String> drivers = new ArrayList<>(); // ArrayList for the drivers
        ArrayList<String> races = new ArrayList<>(); // ArrayList for the races

        // Add test data to the drivers ArrayList
        drivers.add("Lando");
        drivers.add("Max");
        drivers.add("Oscar");
        drivers.add("Kimi");
        drivers.add("Carlos");

        // Add test data to the races ArrayList
        races.add("Silverstone");
        races.add("Bahrain");
        races.add("Jeddah");
        races.add("Spa");
        races.add("Abu Dhabi");

        // Test the constructor and print the class
        RaceSimulator simRace = new RaceSimulator(drivers, races);
        System.out.println(simRace);
    }
}

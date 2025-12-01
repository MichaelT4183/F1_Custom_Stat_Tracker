package packages.seasonMethods;

import java.util.HashMap; // Used for championship points
import java.util.LinkedHashMap; // Used for sorting the championship points
import java.util.List; // Used for sorting the championship points
import java.util.Map; // Used for sorting the championship points
import java.util.ArrayList; // Used to store the list of drivers
import java.util.Collections; // Used for sorting the championship points
import java.util.Comparator; // Used for sorting the championship points
import java.lang.StringBuilder; // Used for formatting the championship table

/* This class is designed to create, store and append a championship
table for the F1 race season. This class stores the name of the driver and
their points in a HashMap (which closely relates a table) and can be updated
and displayed to the user*/
public class ChampionshipTable
{
    // Create the private variables so users can't change them without the functions
    private HashMap<String, Integer> championshipPoints;
    private Map<String, Integer> sortedChampionshipPoints;
    private ArrayList<String> drivers;

    // Create the java constructor
    public ChampionshipTable(ArrayList<String> userDrivers)
    {
        // Initialise the variables
        this.drivers = userDrivers;
        this.championshipPoints = new HashMap<>();
        // Create the base championship table
        setChampionshipTable(drivers);
    }

    // Method to set the championship table based off the number of drivers and give them all 0 points
    private void setChampionshipTable(ArrayList<String> drivers)
    {
        for(int i = 0; i < drivers.size(); i++)
        {
            this.championshipPoints.put(drivers.get(i), 0);
        }
    }

    // Method to change the championship table for drivers who got points
    public void appendChampionshipTable(String[] raceFinish)
    {
        // A for loop to go through the race finishers and update their points
        for(int i = 0; i < raceFinish.length; i++)
        {
            // Get the driver's name and the points for their finish position
            String driverName = raceFinish[i];
            int racePoints = getFinishPoints(i);
            // Get the driver's current championship points
            int driverTotalPoints = championshipPoints.get(driverName);
            // Add the driver's current points and their race points and update the championship table
            int newPoints = racePoints + driverTotalPoints;
            this.championshipPoints.replace(driverName, newPoints);
            // Sort the championship HashMap in decsending order
            sortedChampionshipPoints = sortChampionshipPoints(championshipPoints);
        }
    }

    // Method to get the points for whoever finished
    private int getFinishPoints(int position)
    {
        // Check to see if the driver finished within the top 10
        if(position < 10)
        {
            int[] points = {25, 18, 15, 12, 10, 8, 6, 4, 2, 1};

            return points[position];
        }
        // If driver finished out of the top 10
        else 
        {
            return 0;
        }
    }

    // Method to sort the championship table in decsending order
    private Map<String, Integer> sortChampionshipPoints(HashMap<String, Integer> championshipPoints)
    {
        // Convert championship points HashMap to an ArrayList
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(championshipPoints.entrySet());
        // Sort the list by value in descending order
        Collections.sort(entryList, new Comparator<Map.Entry<String, Integer>>() 
        {
            @Override // Overrides the current compare method with a new one
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2)
            {
                return e2.getValue().compareTo(e1.getValue());
            }
        });

        // Create a LinkedHashMap to preserve the order
        Map<String, Integer> sortedChampionshipTable = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : entryList)
        {
            sortedChampionshipTable.put(entry.getKey(), entry.getValue());
        }

        // Returns the sorted LinkedHashMap in decsending order
        return sortedChampionshipTable;
    }

    // Display the current championship standings
    public String toString()
    {
        // Checks to see if the sorted table is null. If not, it displays the sorted table
        if (sortedChampionshipPoints !=null)
        {
            // StringBuilder to add the championship points to a formatted mutable string
            StringBuilder sb = new StringBuilder("\nHere is the current championship table:\n\n");
            int i = 1;
            for (Map.Entry<String, Integer> entry : sortedChampionshipPoints.entrySet())
            {
                sb.append(i + ". " + entry.getKey() + ": " + entry.getValue() + "\n"); // Add a new entry to the string
                i++;
            }
            return sb.toString();
        }
        // Will return the unsorted table (When it is first created) if the other is null
        else
        {
            // StringBuilder to add the championship points to a formatted mutable string
            StringBuilder sb = new StringBuilder("\nHere is the current championship table:\n\n");
            int i = 1;
            for (Map.Entry<String, Integer> entry : championshipPoints.entrySet())
            {
                sb.append(i + ". " + entry.getKey() + ": " + entry.getValue() + "\n"); // Add a new entry to the string
                i++;
            }
            return sb.toString();
        }
    }
}
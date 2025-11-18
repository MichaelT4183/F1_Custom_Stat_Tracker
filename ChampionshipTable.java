import java.util.HashMap;
import java.util.ArrayList;

public class ChampionshipTable
{
    private HashMap<String, Integer> championshipPoints;
    private ArrayList<String> drivers;

    // Create the java constructor
    public ChampionshipTable(ArrayList<String> drivers)
    {
        this.drivers = drivers;
    }

    public void setChampionshipTable()
    {
        for(int i = 0; i < drivers.size(); i++)
        {
            this.championshipPoints.put(drivers.get(i), 0);
        }
    }

    public void appendChampionshipTable(String[] raceFinish)
    {
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
        }
    }

    // Method to get the points for whoever finished
    private int getFinishPoints(int i)
    {
        // Check to see if the driver finished within the top 10
        if(i < 10)
        {
            int[] points = {25, 18, 15, 12, 10, 8, 6, 4, 2, 1};

            return points[i];
        }
        // If driver finished out of the top 10
        else 
        {
            return 0;
        }
    }
}
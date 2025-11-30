package packages.seasonMethods;

import java.util.ArrayList;

public class StatCounter
{
    private ArrayList<String> drivers; // Get the drivers competing in the season
    private String[] podium = new String[3]; // Get the podium for each race

    public StatCounter(ArrayList<String> drivers, ArrayList<String> races)
    {
        this.drivers = drivers;
    }

    // Method to get the stats
    public void getStats(String raceName, String raceWeather, String[] raceFinish)
    {
        // Get the podium finish
        for(int i = 0; i < 3; i++)
        {
            podium[i] = raceFinish[i]; // Assigns the top 3 finishers to the podium
        }

        String weather = raceWeather; // Get the weather of the race
        String nameOfRace = raceName; // Get the name of the race
    }
}
package packages.seasonMethods;

import java.util.ArrayList;
import java.io.File; // Used for creating a file
import java.io.FileWriter; // Used for writing to the file
import java.io.IOException; // Used for error checking for the file

public class StatCounter
{
    ChampionshipTable championship; // Get the championship table into this file
    private ArrayList<String> drivers; // Get the drivers competing in the season
    private ArrayList<String> races; // Get the races in the season
    private String[] podium = new String[3]; // Get the podium for each race
    private File seasonSummary = new File("Season Summary.txt");

    public StatCounter(ArrayList<String> drivers, ArrayList<String> races, ChampionshipTable championship)
    {
        // Initialize the variables
        this.drivers = drivers;
        this.races = races;
        this.championship = championship;
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
        // Write to the file
        writeToFile(weather, nameOfRace);
    }

    // Method to write an individual race to the .txt file
    private void writeToFile(String weather, String nameOfRace)
    {
        try
        {
            FileWriter writer = new FileWriter(seasonSummary, true); // Uses true to append to the file instead of overwriting it
            // Write all of the drivers in the season
            writer.write("Here is your list of drivers:\n");
            for(int i = 0; i < drivers.size(); i++)
            {
                writer.write(drivers.get(i));
            }
            // Write all of the races in the season
            writer.write("Here is your list of races:\n");
            for(int i = 0; i < races.size(); i++)
            {
                writer.write(races.get(i));
            }
            writer.write("\n____________________\n"); // Blocks out overview from the races
            writer.write("Name of the race: "+nameOfRace+"\n"); // Writes the name of the race
            writer.write("Weather for the race: "+weather+"\n\n"); // Writes the weather of the race
            writer.write("Winner: "+podium[0]+"\n"); // Writes the winner of the race
            writer.write("Podium:\n1st: "+podium[0]+"\n2nd: "+podium[1]+"\n3rd: "+podium[2]+"\n\n"); // Writes the podium of the race
            writer.write("The championship table after "+nameOfRace+":\n");
            writer.write(championship.toString()); // Writes the championsip table after the race happened
            writer.close(); // Closes the writer
        }
        // Throw an error if the file cannot be written to
        catch (IOException e)
        {
            System.out.println("There was an error creating the file.");
            e.printStackTrace();
        }
    }
}
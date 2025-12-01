package packages.seasonMethods;

import java.util.ArrayList;
import java.io.File; // Used for creating a file
import java.io.FileWriter; // Used for writing to the file
import java.io.IOException; // Used for error checking for the file

/* This class is designed to get data about a race from the RaceSimulator.java file and
write the information of the race to a .txt file which can be used to look back on
the simulated season even if the user stops the simulation. It will also keep track of
any other custom seasons that are simulated and store them in the same file */
public class StatCounter
{
    private ChampionshipTable championship; // Get the championship table into this file
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
        writeToStartOfFile(); // Write the beginning information of the season to the file (Data that does not need to be repeated)
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
        writeToFile(weather, nameOfRace, raceFinish); // Write the race information
    }

    /* Method to create the start of the file
    This is to prevent the welcome messages at the start
    of the file from being repeated every time it is written to */
    private void writeToStartOfFile()
    {
        try
        {
            FileWriter writer = new FileWriter(seasonSummary, true); // Uses true to append to the file instead of overwriting it
            writer.write("Here is your summary of the race season\n\n");
            // Write all of the drivers in the season
            writer.write("Here are the drivers involved in the season:\n");
            for(int i = 0; i < drivers.size(); i++)
            {
                writer.write(drivers.get(i)+", ");
            }

            // Write all of the races in the season
            writer.write("\n\nHere are the races in the season calendar:\n");
            for(int i = 0; i < races.size(); i++)
            {
                writer.write(races.get(i)+", ");
            }
            writer.close(); // Closes the writer
        }
        // Throw an error if the file cannot be written to and displays the error
        catch (IOException e)
        {
            System.out.println("There was an error creating the file.");
            e.printStackTrace();
        }
    }

    // Method to write an individual race to the .txt file
    private void writeToFile(String weather, String nameOfRace, String[] raceFinish)
    {
        try
        {
            FileWriter writer = new FileWriter(seasonSummary, true); // Uses true to append to the file instead of overwriting it
            writer.write("\n____________________\n\n"); // Block out from the races
            writer.write("Name of the race: "+nameOfRace+"\n"); // Writes the name of the race
            writer.write("Weather for the race: "+weather+"\n\n"); // Writes the weather of the race
            writer.write("Winner: "+podium[0]+"\n\n"); // Writes the winner of the race
            // Writes the finishing positions of the drivers
            for(int i = 0; i < drivers.size(); i++)
            {
                writer.write("P"+(i+1)+": "+raceFinish[i]+"\n");
            }
            writer.write("\n"+championship.toString()); // Writes the championsip table after the race happened
            writer.close(); // Closes the writer
        }
        // Throw an error if the file cannot be written to and displays the error
        catch (IOException e)
        {
            System.out.println("There was an error creating the file.");
            e.printStackTrace();
        }
    }
}
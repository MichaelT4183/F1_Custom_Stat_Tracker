import java.util.HashMap;

public class ChampionshipTable
{
    private HashMap<String, Integer> championshipPoints;
    private ArrayList<String> drivers;

    // Create the java constructor
    public ChampionshipTable(ArrayList<String> drivers)
    {
        this.drivers = drivers;
    }

    public void setChampionshipTable(ArrayList<String> drivers)
    {
        for(int i = 0; i < drivers.size(); i++)
        {
            championshipPoints.put(drivers.get(i), 0);
        }
    }

    public void appendChampionshipTable(ArrayList<String> raceFinish)
    {
        for(int i = 0; i < raceFinish.size(); i++)
        {
            String driverName = raceFinish.get(i);
            championshipPoints.replace();
        }
    }
}
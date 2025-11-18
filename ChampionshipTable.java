public class ChampionshipTable
{
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
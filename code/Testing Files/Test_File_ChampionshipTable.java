import java.util.ArrayList; // Used for the test list of drivers
import seasonMethods.ChampionshipTable; // Import the package for testing

public class Test_File_ChampionshipTable
{
    public static void main(String[] args) 
    {
        ArrayList<String> drivers = new ArrayList<>(); // ArrayList for test data (Driver names)
        ChampionshipTable table = new ChampionshipTable(drivers);
    }
}
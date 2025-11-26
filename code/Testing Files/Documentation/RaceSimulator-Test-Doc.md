## Testing Documentation for RaceSimulator.java
This documentation will highlight what tests have been conducted, the results of those test and any actions on those tests.

___

### Test 1 - Testing the Java Constructor
This test is to make sure that the java constructor initializes the variable correctly and does not throw an error.
```
// Create the java constructor
public RaceSimulator(ArrayList<String> drivers, ArrayList<String> races)
{
    // Initialize the variables
    this.drivers = drivers;
    this.races = races;
}
```
  
This has been done using the following test data:
```
// Test the constructor and print the class
RaceSimulator simRace = new RaceSimulator(drivers, races);
System.out.println(simRace);
```
#### Result
I was given a **'Exception in thread "main" java.lang.NullPointerException'** error message. This is due to the **RaceSimulator.java** file calling the **ChampionshipTable.java**.

#### Updates and actions
The reason for the error was that I called the constructor in the **ChampionshipTable.java** file too early and not in a method. I have moved this just above the line of code in **RaceSimulator.java** where I call the **ChampionshipTable.java** file.
#### RaceSimulator.java -> Method: getRaceFinish
```
ChampionshipTable championship = new ChampionshipTable(drivers);
championship.appendChampionshipTable(raceFinish); // Sends the race finish to ChampionshipTable.java to append the table
```

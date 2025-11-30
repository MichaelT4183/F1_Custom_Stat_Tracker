## Testing Documentation for StatCounter.java

This documentation will highlight what tests have been conducted, the results of those test and any actions on those tests.

### Dependencies
This file is being tested through the **'Test_File_RaceSimulator.java'** testing file as it is dependant on the race being simulated. The **StatCounter.java** file will store and write data 1 race at a time. As it is designed to be used once a race has simulated without any extra user input, there is no need for a seperate test file
___

### Test 1 - Testing the Java Constructor
This test is to check that the java constructor initializes the variables correctly and does not throw an error.
```
public StatCounter(ArrayList<String> drivers, ArrayList<String> races, ChampionshipTable championship)
    {
        // Initialize the variables
        this.drivers = drivers;
        this.races = races;
        this.championship = championship;
    }
```
using the following test data:
```
StatCounter stats = new StatCounter(drivers, races, championship);
stats.getStats(raceName, weather, raceFinish);
```

### Results
The file is successfully created and wrote to the file correctly. No errors were thrown.

### Updates and actions
I have changed the code very slightly to format the .txt file as intended as there were a few issues with how it. I also added an additional method to the file to stop the welcoming messages from repeating constantly.
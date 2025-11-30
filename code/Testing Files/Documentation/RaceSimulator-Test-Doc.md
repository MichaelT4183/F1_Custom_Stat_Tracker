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

___

### Test 2 - Run the full program
This test is to see whether the code functions correctly when you simulate the races. This test checks that the race name, weather and driver finishing positions display correctly and outputs it to the **ChampionshipTable.java** file to update the table using the following test data:
```
// Add test data to the drivers ArrayList
drivers.add("Lando");
drivers.add("Max");
drivers.add("Oscar");
drivers.add("Kimi");
drivers.add("Carlos");

// Add test data to the races ArrayList
races.add("Silverstone");
races.add("Bahrain");
races.add("Jeddah");
races.add("Spa");
races.add("Abu Dhabi");

RaceSimulator simRace = new RaceSimulator(drivers, races);

for(int i = 0; i < races.size(); i++)
{
    simRace.simulateRace(i);
}
```

#### Result
I was given a **'Exception in thread "main" java.lang.NullPointerException'** error message. The code displays the race nae=me and the weather correctly. For the race finishes, it prints the first 3 drivers and then displays **null** for the others. I got the following as the system output:
```
The next race is: Silverstone

Weather: Dry

Here is your race result:

1. Max
2. Lando
3. Oscar
4. null
5. null
```
#### Updates and actions
The reason for the error was when attempting to copy the **drivers** ArrayList to the **driverListCopy**, it didn't copy and when removing drivers so there are no duplicates in the race finish, I was deleting the original ArrayList of drivers. I updated the code from:
```
ArrayList<String> driverListCopy = drivers;
```
to
```
ArrayList<String> driverListCopy = new ArrayList<>(drivers);
```

___

### Test 3 - Displaying the championship table after the race simulations
This test is to make sure that the championship table will output when the races have finished and show the final standings
```
ChampionshipTable championship = new ChampionshipTable(drivers);
System.out.println(championship);
```

#### Result
The code runs, but as i have called the constructor again in a seperate file, it will reset the championship table and will not display the updated one

#### Updates and actions
After testing, I realised that it was an issue with initializing the **ChampionshipTable.java** constructor from the **RaceSimulator.java** file. I had to initialize the **ChampionshipTable.java** constructor within the **RaceSimulator.java** constructor using the following code:
```
private ChampionshipTable championship;

// Create the java constructor
public RaceSimulator(ArrayList<String> drivers, ArrayList<String> races)
{
    // Initialize the variables
    this.drivers = drivers;
    this.races = races;
    this.championship = new ChampionshipTable(drivers);
}
```
After implementing this, the code works as intended as correctly updates the championship table with the following update:
```
The next race is: Silverstone

Weather: Dry

Here is your race result:

1. Kimi
2. Lando
3. Max
4. Carlos
5. Oscar
Here is the current championship table:

1. Kimi: 25
2. Lando: 18
3. Max: 15
4. Carlos: 12
5. Oscar: 10

Please type 'next' to move onto the next race
> next
The next race is: Bahrain

Weather: Dry

Here is your race result:

1. Max
2. Carlos
3. Lando
4. Kimi
5. Oscar
Here is the current championship table:

1. Max: 40
2. Kimi: 37
3. Lando: 33
4. Carlos: 30
5. Oscar: 20

Please type 'next' to move onto the next race
```

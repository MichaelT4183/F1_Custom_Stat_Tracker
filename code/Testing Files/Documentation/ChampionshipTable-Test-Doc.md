## Testing Documentation for ChampionshipTable.java

This documentation will highlight what tests have been conducted, the results of those test and any actions on those tests.

___

### Test 1 - Testing the Java Constructor and printing the class
This test is to check that the java constructor initializes the variables correctly, prints the LinkedHashMap and does not throw an error.
```
// Create the java constructor
  public ChampionshipTable(ArrayList<String> userDrivers)
  {
      // Initialise the variables
      this.drivers = userDrivers;
      // Create the base championship table
      setChampionshipTable(drivers);
  }
```
  
This has been done using the following test data:
```
ArrayList<String> drivers = new ArrayList<>(); // ArrayList for test data (Driver names)

// Test the constructor
ChampionshipTable table = new ChampionshipTable(drivers);

// Populate the driver's ArrayList for test data
drivers.add("Lando");
drivers.add("Charles");
drivers.add("Max");

// Test to try and print the championship table before populating it (Should return an error)
System.out.println(table);
```
#### Result
The constructor initialized. however, the championship table returned null and then threw an error. This is because the **'toString'** method was only returning the **sortedChampionshipTable** variable even though it has not been defined and is **null**.

#### Updates and Actions
I have included an **if statement** to see if the **'toString'** method was being called before appending the LinkedHashMap. This would then return the original **championshipTable** variable with the default variables. The following code is within the **'toString'** method:
```
if (sortedChampionshipPoints !=null)
{
  return "Here is the current championship table:\n\n" + sortedChampionshipTable;
}
else
{
  return "Here is the current championship table:\n\n" + championshipTable;
}
```

___

### Test 2 - Printing class after 'If Statement' **_(In test 1)_**
This test is to check whether the **'toString'** output works correctly after the actions in Test 1 using the following test code:
```
ArrayList<String> drivers = new ArrayList<>(); // ArrayList for test data (Driver names)

// Test the constructor
ChampionshipTable table = new ChampionshipTable(drivers);

// Populate the driver's ArrayList for test data
drivers.add("Lando");
drivers.add("Charles");
drivers.add("Max");

// Test to try and print the championship table before populating it (Should return an error)
System.out.println(table);
```
#### Result
The constructor initialized. however, it still returned as **null** after running the program. This was caused because of the **'championshipPoints'** HashMap not being initialized correctly, so it did not add anything to the HashMap, causing it to return as **null**.

#### Updates and Actions
I have initialized the **'championshipPoints'** HashMap within the constructor. This is so that it is initialized and will start to add the values of the drivers to the HashMap and will print out the championship table. I have also moved the HashMap test data up in the code as it was still printing null values after the changes. I have added the following code to the java constructor:
```
this.championshipPoints = new HashMap<>();
```

___

### Test 3 - Appending the championship
This test is designed to see whether the rest of the modules work correctly. This is done by using the **appendChampionshipTable** method as the others are private to that class. This should then create the LinkedHashMap and should output the new **sortedChampionshipTable** variable and display the drivers' scores in decsending order. This was done using the following test code:
```
// Create the race finish and attempt to append the championship table
String raceFinish[] = {"Lando", "Max", "Charles"}; // Array for test data (Race finish)
table.appendChampionshipTable(raceFinish);

// Check to see if the championship table has been altered
System.out.println(table);
```

#### Result
The championship table was appended successfully and displayed the drivers in the correct order. No errors were thrown during testing.

___

### Test 3 - Appending the championship multiple times
This test is designed to see if the program can append the championship multiple times, add the 2 different scores together and still keeps the order from highest to lowest. This was done using the following test code:
```
// Create the race finish and attempt to append the championship table
String raceFinish[] = {"Lando", "Max", "Charles"}; // Array for test data (Race finish)
table.appendChampionshipTable(raceFinish);

// Check to see if the championship table has been altered
System.out.println(table);

// Create a 2nd race finish and attempt to append the championship table again
String raceFinish2[] = {"Max", "Charles", "Lando"}; // Array for test data (Race finish)
table.appendChampionshipTable(raceFinish2);

// Check to see if the championship table has been altered
System.out.println(table);
```

#### Result
The program works correctly and doesn't override the scores when a new set is appended into the LinkedHashMap and kept the correct order for the championship table.
The championship table was appended successfully and displayed the drivers in the correct order. No errors were thrown during testing.

#### Updates and Actions
I have included formatting for the output of the championship table to make it look nicer and easier to understand. This also made sure that it wasn't all on one line. I did this by using the follwowing code:
```
// Checks to see if the sorted table is null. If not, it displays the table
if (sortedChampionshipPoints !=null)
{
    // StringBuilder to add the championship points to a formatted mutable string
    StringBuilder sb = new StringBuilder("Here is the current championship table:\n\n");
    int i = 1;
    for (Map.Entry<String, Integer> entry : sortedChampionshipPoints.entrySet())
    {
        sb.append(i + ". " + entry.getKey() + ": " + entry.getValue() + "\n"); // Add a new entry to the string
        i++;
    }
    return sb.toString();
}
// Will return the unsorted table (When it is first created) if the other is null
else
{
    // StringBuilder to add the championship points to a formatted mutable string
    StringBuilder sb = new StringBuilder("Here is the current championship table:\n\n");
    int i = 1;
    for (Map.Entry<String, Integer> entry : championshipPoints.entrySet())
    {
        sb.append(i + ". " + entry.getKey() + ": " + entry.getValue() + "\n"); // Add a new entry to the string
        i++;
    }
    return sb.toString();
}
```
This code has been implemented within the **'toString'** method and within the if statement. Using a **StringBuilder** allows me to combine all of the entries of the LinkedHashMap and print them on every line in a single variable and then display it so it looks like a table.

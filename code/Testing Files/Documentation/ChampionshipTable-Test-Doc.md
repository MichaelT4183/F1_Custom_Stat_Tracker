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

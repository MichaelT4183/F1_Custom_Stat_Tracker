## Testing Documentation for DriverAndRaceDetails.java

This documentation will highlight what tests have been conducted, the results of those test and any actions on those tests.

___

### Test 1 - Testing the Java Constructor
This test is to make sure that the java constructor initializes the variable correctly and does not throw an error.
```
public DriverAndRaceDetails(String userName)
    {
        this.userName = userName;
    }
```
  
This has been done using the following test data:
```
// Get the user's name
Scanner scanner = new Scanner(System.in);
System.out.println("Please enter your name");
String name = scanner.nextLine();

// Test the constructor and that it works
DriverAndRaceDetails details = new DriverAndRaceDetails(name);
```
#### Result
The java constructor initialized the variable correctly and did not throw an error.

___

### Test 2 - Testing the getDriverNames and getRaceNames methods
This test is to see if any errors are thrown when inputting the drivers ArrayList and the races ArrayList
```
// Method used to get the names of the drivers
    public void getDriverNames()
    {
        String driverName = "";
        System.out.println(userName+", please input the names of the drivers. Type 'stop' to end:");

        // Allow the user the keep adding names until they type 'stop'
        while(!driverName.equals("stop"))
        {
            driverName = scanner.nextLine();
            // Stops the while loop when the user inputs 'stop'
            if(driverName.equals("stop"))
            {
                break;
            }
            drivers.add(driverName); // Add the name to the ArrayList
        }
    }
```
and
```
// Method used to get the names of the races
    public void getRaceNames()
    {
        String raceName = "";
        System.out.println("\n"+userName+", please input the names of the races. Type 'stop' to end:");

        // Allow the user the keep adding names until they type 'stop'
        while(!raceName.equals("stop"))
        {
            raceName = scanner.nextLine();
            // Stops the while loop when the user inputs 'stop'
            if(raceName.equals("stop"))
            {
                break;
            }
            races.add(raceName); // Add the race to the ArrayList
        }
    }
```

This has been done by using the following test data:
```
 // Test inputting the driver names
details.getDriverNames();
// Test inputting the race names
details.getRaceNames();
```

#### Result
No error was thrown and the code allows the user to input the drivers and the races that they want to use in the season simulation

___
### Test 3 - Printing the class 
This test is to check that both the driver names and the race names will be outputted once you have used the methods 'getDriverNames' and 'getRaceNames' (Featured in test 2). It uses the following test code:
```
// Test that the ArrayLists are displayed to the user
System.out.println(details);
```

#### Result
Nothing was printed out due to getting a "Cannot invoke" error because there was not a 'toString' method in the file.

#### Updates and Actions
After the test, I have included a 'toString' method which will output both the drivers and the races the user inputted into the method previously. This has been done using the following code:
```
// toString method to display the list of drivers and races
public String toString()
{
    return "Your drivers are: "+drivers+"\n\nYour races are: "+races;
}
```
___
### Test 4 - Printing the class after changes
This test is to check that the "Cannot invoke" error has been fixed. This is using the following test code:
```
// Test that the ArrayLists are displayed to the user
System.out.println(details);
```

#### Result
The code outputs both the drivers and races that the user inputted successfully and does not throw any errors.

#### Updates and actions
After the final test, I have added extra comment in the file to explain what it does and changed variable names within the methods to make it easier to understand the variable names.

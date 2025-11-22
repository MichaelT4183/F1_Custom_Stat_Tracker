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


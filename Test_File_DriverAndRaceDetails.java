import java.util.Scanner;

public class Test_File_DriverAndRaceDetails
{
    // Main method used to test the file
    public static void main(String[] args)
    {
        // Get the user's name
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your name");
        String name = scanner.nextLine();

        // Test the constructor and that it works
        DriverAndRaceDetails details = new DriverAndRaceDetails(name);

        // Test inputting the driver names
        details.driverNames();
        // Test inputting the race names
        details.raceNames();

        System.out.println(details);

        scanner.close();
    }

}
import java.util.Scanner;

public class Test_File_DriverAndRaceDetails
{
    // Main method used to test the file
    public static void main(String[] args)
    {
        // Get the user's name
        Scanner scanner = new Scanner(System.in);
        System.out.println("Test");
        String name = scanner.nextLine();
        // Test the constructor and that it works
        DriverAndRaceDetails details = new DriverAndRaceDetails(name);
        System.out.println(details);


        scanner.close();
    }

}
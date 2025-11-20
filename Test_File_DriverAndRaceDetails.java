import java.util.Scanner;

public class Test_File_DriverAndRaceDetails
{
    public static void main(String[] args)
    {
        // Get the user's name
        Scanner scanner = new Scanner(System.in);
        System.out.println("Test");
        String name = scanner.nextLine();
        DriverAndRaceDetails details = new DriverAndRaceDetails(name);


        
        scanner.close();
    }

}
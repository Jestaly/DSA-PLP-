
import java.util.*;

public class Main {

    public static boolean leapYear(int year) {

        boolean leapYear = false;

        if (year % 4 == 0) {
            return leapYear = true;
        }
        return leapYear;

    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a year: ");
        int year = scanner.nextInt();

        System.out.println("the year " + year + " is " + leapYear(year) + " leap year.");
        scanner.close();
    }
}
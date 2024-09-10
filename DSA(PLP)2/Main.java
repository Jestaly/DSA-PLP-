import java.util.Scanner;

public class Main {

    public static double result = 0;

    public static double consoleCalculator() {
        Scanner scanner = new Scanner(System.in);
        double[] num = new double[2];

        for (int i = 0; i < num.length; i++) {
            System.out.print("Enter Digit Number " + (i + 1) + ": ");
            num[i] = scanner.nextDouble();

        }

        scanner.nextLine();

        System.out.print("Select Operation: ");
        String operation = scanner.nextLine();

        if (operation.equals("+")) {
            System.out.println(sum(num));
        } else if (operation.equals("-")) {
            System.out.println(difference(num));
        } else if (operation.equals("*")) {
            System.out.println(product(num));
        } else if (operation.equals("/")) {
            System.out.println(quotient(num));
        } else {
            System.out.println("it is not an operator.");
        }
        scanner.close();
        return 0;
    }

    public static double sum(double[] num) {
        for (int i = 0; i < num.length; i++) {
            result += num[i];
        }
        return result;
    }

    public static double difference(double[] num) {
        return result = num[0] - num[1];
    }

    public static double product(double[] num) {
        result = 1;
        for (int i = 0; i < num.length; i++) {
            result *= num[i];
        }
        return result;
    }

    public static double quotient(double[] num) {
        result = 1;
        return result = num[0] / num[1];
    }

    public static void main(String args[]) {

        consoleCalculator();
    }

}

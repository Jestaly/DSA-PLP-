package DSAPLP3;

import java.util.*;

public class Main {
    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);
        ArrayOperations arrayOperations = new ArrayOperations();

        boolean loop = true;

        while (loop) {

            System.out.println("---------MENU---------");
            System.out.println("[1] CREATE ARRAY");
            System.out.println("[2] INSERT ELEMENTS");
            System.out.println("[3] SEARCH");
            System.out.println("[4] DISPLAY");
            System.out.println("[5] DELETE");
            System.out.println("[0] STOP");

            System.out.print("ENTER CHOICE: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("----------------------");
                    System.out.println();
                    if (arrayOperations.getSize() == 0) {
                        arrayOperations.createArray();
                    } else {
                        System.out.println("There's already an existing Array.");
                    }
                    System.out.println();
                    break;
                case 2:
                    System.out.println("----------------------");
                    System.out.println();
                    if (arrayOperations.getSize() != 0) {
                        arrayOperations.insertElement();
                    } else {
                        System.out.println("Create an Array first.");
                    }

                    System.out.println();
                    break;
                case 3:
                    System.out.println("----------------------");
                    System.out.println();
                    if (arrayOperations.getSize() != 0) {
                        arrayOperations.searchElement();
                    } else {
                        System.out.println("Create an Array first.");
                    }
                    System.out.println();
                    break;
                case 4:
                    System.out.println("----------------------");
                    System.out.println();
                    if (arrayOperations.getSize() != 0) {
                        arrayOperations.displayArray();
                    } else {
                        System.out.println("Create an Array first.");
                    }

                    System.out.println();
                    break;
                case 5:
                    System.out.println("----------------------");
                    System.out.println();
                    if (arrayOperations.getSize() != 0) {
                        arrayOperations.deleteElement();
                    } else {
                        System.out.println("Create an Array first.");
                    }
                    System.out.println();
                    break;
                case 0:
                    System.out.println("----------------------");
                    System.out.println();
                    arrayOperations.stopProgram();
                    System.out.println();
                    System.out.println("----------------------");
                    loop = false;
                    break;
                default:
                    System.out.println("----------------------");
                    System.out.println();
                    System.out.println("ERROR. ENTER VALID INPUT.");
                    System.out.println();

            }
        }
        scanner.close();
    }

}

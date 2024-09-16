package DSAPLP3;

import java.util.*;

public class ArrayOperations {
    Scanner scanner = new Scanner(System.in);
    private int[] array = {};
    private int size = 0;
    private int counter = 0;

    public int[] createArray() {
        System.out.println("creating array.");
        System.out.print("Enter Array size [5-20]: ");
        size = scanner.nextInt();

        if (size >= 5 && size <= 20) {
            array = new int[size];
            System.out.println("An Array with size of " + "(" + size + ")" + " has been created.");
        } else {
            System.out.println("Invalid size.");
            size = 0;
        }

        return array;
    }

    public int[] insertElement() {
        if (counter <= 4) {
            System.out.println("inserting element.");

            for (int i = counter; i < array.length; i++) {
                System.out.println("PRESS [1] TO CONTINUE");
                System.out.println("PRESS [0] TO GO BACK");
                int choice_2 = scanner.nextInt();

                if (choice_2 == 1) {
                    System.out.println("Insert element " + (counter + 1) + ": ");
                    array[i] = scanner.nextInt();
                    counter++;
                } else if (choice_2 == 0) {
                    break;
                } else {
                    System.out.println("Invalid Entry.");
                }

            }
        } else {
            System.out.println("Array is full.");
        }

        return array;
    }

    public int searchElement() {
        System.out.println("searching element.");
        return 0;
    }

    public void displayArray() {
        System.out.println("displaying array.");
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public int deleteElement() {
        System.out.println("deleting element.");
        return 0;
    }

    public void stopProgram() {
        System.out.println("stopping program");
    }

    public int getSize() {
        return size;
    }
}

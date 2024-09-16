package DSAPLP3;

import java.util.*;

public class ArrayOperations {
    Scanner scanner = new Scanner(System.in);
    private int[] array = {};
    private int size = 0;

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

    public int insertElement() {
        System.out.println("inserting element.");
        return 0;
    }

    public int searchElement() {
        System.out.println("searching element.");
        return 0;
    }

    public void displayArray() {
        System.out.println("displaying array.");
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

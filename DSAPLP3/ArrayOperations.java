package DSAPLP3;

import java.util.*;

public class ArrayOperations {
    Scanner scanner = new Scanner(System.in);
    private int[] array = {};
    private int size = 0;
    private int counter = 0;
    int[] tempArray = {};

    public int[] createArray() {
        System.out.println("Creating Array for you...");
        System.out.println();
        System.out.println("----------------------");
        System.out.print("Enter Array size [5-20]: ");
        size = scanner.nextInt();

        if (size >= 5 && size <= 20) {
            array = new int[size];
            System.out.println("----------------------");
            System.out.println();
            System.out.println("An Array with size of " + "(" + size + ")" + " has been created.");
        } else {
            System.out.println("----------------------");
            System.out.println("Invalid size.");
            size = 0;
        }

        return array;
    }

    public int[] insertElement() {

        boolean duplicate = false;

        if (counter <= size - 1) {
            System.out.println("Inserting Element/s...");
            System.out.println();
            System.out.println("----------------------");
            for (int i = counter; i < array.length; i++) {
                System.out.print("Insert element " + (counter + 1) + ": ");
                array[i] = scanner.nextInt();
                for (int j = 0; j < counter; j++) {
                    if (array[i] == array[j]) {
                        duplicate = true;
                    }
                }
                if (array[i] == -99) {
                    break;
                }
                if (duplicate == true) {
                    System.out.println("----------------------");
                    System.out.println();
                    System.out.println("Error. Duplicates Found. Try Again.");
                    break;
                }

                counter++;
            }
        } else {
            System.out.println("Array is full.");
        }

        return array;
    }

    public void searchElement() {
        System.out.println("Searching Element...");
        System.out.println();
        System.out.println("----------------------");
        System.out.print("Search Element: ");
        int search = scanner.nextInt();
        boolean searchBool = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == search) {
                searchBool = true;
                break;
            }

        }
        if (searchBool == true) {
            System.out.println("----------------------");
            System.out.println();
            System.out.println("(" + search + ")" + " Found Succesfully!");
        } else {
            System.out.println("----------------------");
            System.out.println();
            System.out.println("(" + search + ")" + " not Found.");
        }

    }

    public void displayArray() {
        System.out.println("Displaying Array...");
        System.out.println();
        System.out.println("----------------------");
        String newLine = "";
        for (int i = 0; i < tempArray.length; i++) {
            if (i == 4) {
                newLine = "\n";
            }
            if (i == 9) {
                newLine = "\n";
            }
            if (i == 14) {
                newLine = "\n";
            }
            System.out.print(tempArray[i] + " " + newLine);
            newLine = "";
        }
    }

    //
    // DELETE FUNCTION TO BE FIXED SOON.
    //
    public int deleteElement() {
        int temp = 0;

        System.out.println("Deleting Element...");
        System.out.println();
        System.out.println("----------------------");
        System.out.print("Delete Element: ");
        int deleteData = scanner.nextInt();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == deleteData) {
                for (int j = i; j < array.length; j++) {
                    temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                    if (j == size - 1) {
                        tempArray = new int[size - 1];
                        for (int k = 0; k < tempArray.length; k++) {
                            tempArray[k] = array[k];
                        }
                    }
                }
            }

        }

        return 0;
    }

    public void stopProgram() {
        System.out.println("Program Stopped.");
    }

    public int getSize() {
        return size;
    }

}

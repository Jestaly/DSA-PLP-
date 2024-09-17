package DSAPLP3;

import java.util.*;

public class ArrayOperations {
    Scanner scanner = new Scanner(System.in);
    private int[] array = {};
    private int size = 0;
    private int counter = 0;
    int[] tempArray = {};

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

    public void searchElement() {
        System.out.println("searching element.");

        System.out.println("Search Data: ");
        int search = scanner.nextInt();
        boolean searchBool = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == search) {
                searchBool = true;
                break;
            }

        }
        if (searchBool == true) {
            System.out.println(search + " found succesfully!");
        } else if (searchBool == false) {
            System.out.println(search + " found unsuccesfully.");
        }

    }

    public void displayArray() {
        System.out.println("displaying array.");
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

    public int deleteElement() {
        System.out.println("deleting element.");
        int temp = 0;

        System.out.print("Delete Data: ");
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
        System.out.println("stopping program");
    }

    public int getSize() {
        return size;
    }

}

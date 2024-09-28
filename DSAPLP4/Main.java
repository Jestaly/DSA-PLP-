package DSAPLP4;

import java.util.*;

public class Main {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        SortingClass sortingClass = new SortingClass();

        System.out.print("Enter Array Size: ");
        int size = scanner.nextInt();

        int[] num = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.print("Enter Element " + (i + 1) + ": ");
            num[i] = scanner.nextInt();
        }
        boolean loop = true;
        while (loop) {

            System.out.println("---MAIN MENU---");
            System.out.println("[1] BUBBLE SORT");
            System.out.println("[2] SELECTION SORT");
            System.out.println("[3] INSERTION SORT");
            System.out.println("[4] EXIT");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println(sortingClass.bubbleSort(num));
                    break;
                case 2:
                    sortingClass.selectionSort(num);
                    break;
                case 3:
                    sortingClass.insertionSort(num);
                    break;
                case 4:
                    sortingClass.exit();
                    loop = false;
                    break;
                default:
                    System.out.println("INVALID INPUT.");
                    break;
            }
        }
        scanner.close();
    }
}

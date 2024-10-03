package DSAPLP4;

import java.util.*;

public class Main {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        SortingClass sortingClass = new SortingClass();

        System.out.print("Enter Array Size: ");
        int size = scanner.nextInt();

        final int[] num = new int[size];
        int[] numBubbleSort = new int[size];
        int[] numSelectionSort = new int[size];
        int[] numInsertionSort = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.print("Enter Element " + (i + 1) + ": ");
            num[i] = scanner.nextInt();
            numBubbleSort[i] = num[i];
            numSelectionSort[i] = num[i];
            numInsertionSort[i] = num[i];
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
                    sortingClass.bubbleSort(numBubbleSort);
                    numBubbleSort = num;
                    System.out.println(Arrays.toString(num));
                    numBubbleSort = num;
                    break;
                case 2:
                    sortingClass.selectionSort(numSelectionSort);
                    numSelectionSort = num;
                    System.out.println(Arrays.toString(num));
                    numSelectionSort = num;
                    break;
                case 3:
                    sortingClass.insertionSort(numInsertionSort);
                    numInsertionSort = num;
                    System.out.println(Arrays.toString(num));
                    numInsertionSort = num;
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

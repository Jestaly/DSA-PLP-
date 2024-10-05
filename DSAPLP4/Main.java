package DSAPLP4;

import java.util.*;

public class Main {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        SortingClass sortingClass = new SortingClass();

        boolean loopSizeException = true;
        int size = 0;
        while (loopSizeException) {
            try {
                System.out.print("Enter Array Size: ");
                size = scanner.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Invalid Input. Try Again.");
                scanner.next();
            }
        }

        final int[] num = new int[size];

        boolean loopElementException = true;
        int eCounter = 0;
        while (loopElementException) {
            try {
                for (int i = eCounter; i < size; i++) {
                    System.out.print("Enter Element " + (i + 1) + ": ");
                    num[eCounter] = scanner.nextInt();
                    eCounter++;
                }
                break;
            } catch (Exception e) {
                System.out.println("Invalid Input. Try Again.");
                scanner.next();
            }
        }

        boolean loop = true;

        while (loop) {
            int choice = 0;
            boolean loopChoiceException = true;
            while (loopChoiceException) {
                try {
                    System.out.println("---MAIN MENU---");
                    System.out.println("[1] BUBBLE SORT");
                    System.out.println("[2] SELECTION SORT");
                    System.out.println("[3] INSERTION SORT");
                    System.out.println("[4] EXIT");
                    System.out.print("Enter your choice: ");
                    choice = scanner.nextInt();
                    if (!(choice <= 0 || choice >= 5)) {
                        break;
                    }
                    System.out.println("Invalid Input. Try Again.");
                } catch (Exception e) {
                    System.out.println("Invalid Input. Try Again.");
                    scanner.next();
                }
            }
            scanner.nextLine();

            int[] numBubbleSort = new int[size];
            int[] numSelectionSort = new int[size];
            int[] numInsertionSort = new int[size];

            for (int i = 0; i < size; i++) {
                numBubbleSort[i] = num[i];
                numSelectionSort[i] = num[i];
                numInsertionSort[i] = num[i];
            }

            switch (choice) {
                case 1:
                    sortingClass.bubbleSort(numBubbleSort);
                    System.out.println(Arrays.toString(num));
                    break;
                case 2:
                    sortingClass.selectionSort(numSelectionSort);
                    System.out.println(Arrays.toString(num));
                    break;
                case 3:
                    sortingClass.insertionSort(numInsertionSort);
                    System.out.println(Arrays.toString(num));
                    break;
                case 4:
                    if (sortingClass.exit(scanner) == false) {
                        loop = false;
                    }
                    break;
            }
        }
        scanner.close();
    }
}

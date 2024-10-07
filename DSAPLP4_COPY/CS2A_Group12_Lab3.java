package DSAPLP4_COPY;

import java.util.Scanner;

import DSAPLP4.SortingClass;

public class CS2A_Group12_Lab3 {

    private static String givenArray;
    private static String sortedArray;

    // BUBBLE SORT METHOD
    public static void bubbleSort(int[] numB) {

        // PRINTING GIVEN ARRAY VALUES
        System.out.println("========================================================");
        System.out.println("Bubble Sort");
        givenArray = "Given Array Elements: ";
        for (int i = 0; i < numB.length; i++) {
            givenArray += numB[i] + " ";
        }
        System.out.println(givenArray);

        // INITIALIZING VARIABLES
        int temp = Integer.MIN_VALUE;
        int iCounter = 0;

        // A LOOP FOR ITERATIONS
        for (int i = 0; i < numB.length; i++) {
            // A NESTED LOOP TO COMPARE ELEMENTS
            for (int j = 1; j < numB.length; j++) {
                // A CONDITION TO ACTUALLY COMPARE ELEMENTS
                if (numB[iCounter] > numB[j]) {
                    // SWAPPING OF ELEMENTS
                    temp = numB[iCounter];
                    numB[iCounter] = numB[j];
                    numB[j] = temp;
                }
                // A COUNTER WHICH TASK IS TO INCREMENT AND COMPARE ELEMENTS IN A NESTED LOOP
                iCounter++;
            }
            // RESETS COUNTER TO 0 TO START AGAIN FROM THE BEGINNING
            iCounter = 0;

            // A CONDITION IF THE ARRAY REACHES THE LIMIT -- SO IT WILL
            // NOT PRINT ANOTHER ARRAY
            if (i + 1 == numB.length) {
                break;
            }

            // PRINTING THE ARRAYS IN EACH ITERATIONS
            String iteratedArray = (i + 1) + ". ";
            for (int j = 0; j < numB.length; j++) {
                iteratedArray += numB[j] + " ";
            }
            System.out.println(iteratedArray);
        }

        // PRINTING THE SORTED OUTPUT
        sortedArray = "The Sorted Array Elements: ";
        for (int i = 0; i < numB.length; i++) {
            sortedArray += numB[i] + " ";
        }
        System.out.println(sortedArray);
        System.out.println("========================================================");
    }

    // SELECTION SORT METHOD
    public static void selectionSort(int[] numS) {
        // PRINTING GIVEN ARRAY VALUES
        System.out.println("========================================================");
        System.out.println("Selection Sort");
        givenArray = "Given Array Elements: ";
        for (int i = 0; i < numS.length; i++) {
            givenArray += numS[i] + " ";
        }
        System.out.println(givenArray);

        // INITIALIZING VARIABLES
        int temp = Integer.MIN_VALUE;
        int smallestNum = Integer.MIN_VALUE;
        int position = Integer.MIN_VALUE;

        // A LOOP FOR ITERATIONS
        for (int i = 0; i < numS.length; i++) {
            // INITIALIZING A BOOLEAN VARIABLE IN A LOOP EACH ITERATIONS
            boolean arrayInOrder = true;
            // ASSIGNING THE LATEST numS AT INDEX i TO THE smallestNum
            smallestNum = numS[i];
            // LOOP FOR COMPARISON
            for (int j = i; j < numS.length; j++) {
                // A CONDITION TO COMPARE ELEMENTS IN EACH ITERATIONS TO THE VARIABLE
                if (numS[j] <= smallestNum) {
                    // ASSIGNING numS AND ITERATOR IN A VARIABLE
                    smallestNum = numS[j];
                    position = j;

                    // A FLAG USED TO DETERMINE IF ARRAY IS ALREADY SORTED
                    arrayInOrder = false;
                }
            }
            // A CONDITION TO BREAK IF ARRAY IS SORTED
            if (arrayInOrder == true) {
                break;
            }

            // SWAPPING OF ELEMENTS
            temp = numS[i];
            numS[i] = smallestNum;
            numS[position] = temp;

            // A CONDITION TO BREAK IF ARRAY REACHES THE FINAL INDEX
            if (i == numS.length - 1) {
                break;
            }

            // PRINTING ARRAYS IN EACH ITERATIONS
            String iteratedArray = (i + 1) + ". ";
            for (int j = 0; j < numS.length; j++) {
                iteratedArray += numS[j] + " ";
            }
            System.out.println(iteratedArray);
        }

        // PRINTING THE SORTED OUTPUT
        sortedArray = "The Sorted Array Elements: ";
        for (int i = 0; i < numS.length; i++) {
            sortedArray += numS[i] + " ";
        }
        System.out.println(sortedArray);
        System.out.println("========================================================");
    }

    // INSERTION SORT METHOD
    public static void insertionSort(int[] numI) {

        // PRINTING THE GIVEN ARRAY VALUES
        System.out.println("========================================================");
        System.out.println("Insertion Sort");
        givenArray = "Given Array Elements: ";
        for (int i = 0; i < numI.length; i++) {
            givenArray += numI[i] + " ";
        }
        System.out.println(givenArray);

        // INITIALIZING VARIABLES
        int temp = Integer.MIN_VALUE;
        int counter = Integer.MIN_VALUE;
        int iCounter = Integer.MIN_VALUE;

        // LOOP FOR ITERATIONS
        for (int i = 0; i < numI.length; i++) {
            // ASSIGNING i TO iCounter
            iCounter = i;
            // A CONDITION IF i IS NOT EQUAL TO LENGTH - 1 THEN INCREMENT counter BY i+1
            if (i != numI.length - 1) {
                counter = i + 1;
            }
            // A CONDITION OF i IS NOT EQUAL TO 0 THEN START PRINTING THE ARRAYS
            if (i != 0) {
                // PRINTING ARRAYS IN EACH ITERATIONS
                String iteratedArray = iCounter + ". ";
                for (int j = 0; j < numI.length; j++) {
                    iteratedArray += numI[j] + " ";
                }
                System.out.println(iteratedArray);
            }
            // IF i IS EQUAL TO LENGTH - 1 THEN PRINT THE SORTED OUTPUT
            if (i == numI.length - 1) {
                // PRINTING THE SORTED OUTPUT
                sortedArray = "The Sorted Array Elements: ";
                for (int k = 0; k < numI.length; k++) {
                    sortedArray += numI[k] + " ";
                }
                System.out.println(sortedArray);
                System.out.println("========================================================");
                break;
            }
            // A LOOP TO COMPARE EACH ELEMENTS
            while (numI[counter] < numI[iCounter]) {
                // SWAPPING OF ELEMENTS
                temp = numI[counter];
                numI[counter] = numI[iCounter];
                numI[iCounter] = temp;

                // IF THESE TWO VARIABLES ARE NOT EQUAL TO 0 THEN DECREMENT THEM
                if (iCounter != 0 && counter != 0) {
                    iCounter--;
                    counter--;
                }
            }
        }
    }

    // EXIT METHOD
    public static boolean exit(Scanner scanner) {
        // System.out.println("Exiting the program.");
        boolean loop = true;
        while (loop) {
            System.out.println("========================================================");
            System.out.print("Exit the Program? [Y/N]: ");
            String choice2 = scanner.nextLine();

            if (choice2.toLowerCase().equals("n")) {
                System.out.println("========================================================");
                System.out.println("Returning to the Program.");
                System.out.println("========================================================");
                break;
            } else if (choice2.toLowerCase().equals("y")) {
                System.out.println("========================================================");
                System.out.println("Program Exited.");
                System.out.println("========================================================");
                return false;
            } else {
                System.out.println("========================================================");
                System.out.println("Invalid Input. Try Again.");
                System.out.println("========================================================");
            }

        }
        return true;
    }

    // MAIN METHOD
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        SortingClass sortingClass = new SortingClass();

        boolean loopSizeException = true;
        int size = 0;
        while (loopSizeException) {
            try {
                System.out.print("Enter Array Size: ");
                size = scanner.nextInt();
                System.out.println("========================================================");
                break;
            } catch (Exception e) {
                System.out.println("========================================================");
                System.out.println("Invalid Input. Try Again.");
                System.out.println("========================================================");
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
                    System.out.println("========================================================");
                    eCounter++;
                }
                break;
            } catch (Exception e) {
                System.out.println("========================================================");
                System.out.println("Invalid Input. Try Again.");
                System.out.println("========================================================");
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
                    System.out.println("========================================================");
                    System.out.print("Enter your choice: ");
                    choice = scanner.nextInt();
                    if (!(choice <= 0 || choice >= 5)) {
                        break;
                    }
                    System.out.println("========================================================");
                    System.out.println("Invalid Input. Try Again.");
                    System.out.println("========================================================");
                } catch (Exception e) {
                    System.out.println("========================================================");
                    System.out.println("Invalid Input. Try Again.");
                    System.out.println("========================================================");
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
                    bubbleSort(numBubbleSort);
                    break;
                case 2:
                    selectionSort(numSelectionSort);
                    break;
                case 3:
                    insertionSort(numInsertionSort);
                    break;
                case 4:
                    if (exit(scanner) == false) {
                        loop = false;
                    }
                    break;
            }
        }
        scanner.close();
    }
}

package DSAPLP4_COPY;

import java.util.Arrays;
import java.util.Scanner;

public class CS2A_Group12_Lab3 {

    private static String givenArr;
    private static String sortedArr;

    // AUTOMATIC SORT CHECKER
    public static int[] autoSorter(int[] autoArr) {
        int temp = 0;
        int iCounter = 0;
        for (int i = 0; i < autoArr.length; i++) {
            for (int j = 1; j < autoArr.length; j++) {
                if (autoArr[iCounter] > autoArr[j]) {
                    // SWAPPING OF ELEMENTS
                    temp = autoArr[iCounter];
                    autoArr[iCounter] = autoArr[j];
                    autoArr[j] = temp;
                }
                iCounter++;
            }
            iCounter = 0;
        }
        return autoArr;
    }

    // PRINTS GIVEN ARRAY
    public static void printGivenArray(int[] numArr) {
        System.out.println("========================================================");
        System.out.println("Bubble Sort");
        givenArr = "Given Array Elements: ";
        for (int i = 0; i < numArr.length; i++) {
            givenArr += numArr[i] + " ";
        }
        System.out.println(givenArr);
    }

    // PRINTS ITERATED ARRAY
    public static void printIteratedArray(int[] numArr, int i) {
        String iteratedArr = (i + 1) + ". ";
        for (int j = 0; j < numArr.length; j++) {
            iteratedArr += numArr[j] + " ";
        }
        System.out.println(iteratedArr);
    }

    // PRINTS SORTED ARRAY
    public static void printOutputArray(int[] numArr) {
        sortedArr = "The Sorted Array Elements: ";
        for (int i = 0; i < numArr.length; i++) {
            sortedArr += numArr[i] + " ";
        }
        System.out.println(sortedArr);
        System.out.println("========================================================");
    }

    // BUBBLE SORT METHOD
    public static void bubbleSort(int[] bubArr, int[] autoArr) {

        // PRINTING GIVEN ARRAY VALUES
        printGivenArray(bubArr);

        // INITIALIZING VARIABLES
        int temp = Integer.MIN_VALUE;
        int iCounter = 0;

        // A LOOP FOR ITERATIONS
        for (int i = 0; i < bubArr.length; i++) {
            // A NESTED LOOP TO COMPARE ELEMENTS
            for (int j = 1; j < bubArr.length; j++) {
                // A CONDITION TO ACTUALLY COMPARE ELEMENTS
                if (bubArr[iCounter] > bubArr[j]) {
                    // SWAPPING OF ELEMENTS
                    temp = bubArr[iCounter];
                    bubArr[iCounter] = bubArr[j];
                    bubArr[j] = temp;
                }
                // A COUNTER WHICH TASK IS TO INCREMENT AND COMPARE ELEMENTS IN A NESTED LOOP
                iCounter++;
            }
            // RESETS COUNTER TO 0 TO START AGAIN FROM THE BEGINNING
            iCounter = 0;

            // PRINTING THE ARRAYS IN EACH ITERATIONS
            printIteratedArray(bubArr, i);

            // COMPARES ARRAY TO SORTED ARRAY
            if (Arrays.equals(bubArr, autoSorter(autoArr))) {
                break;
            }

        }

        // PRINTING THE SORTED OUTPUT
        printOutputArray(bubArr);
    }

    // SELECTION SORT METHOD
    public static void selectionSort(int[] selArr, int[] autoArr) {
        // PRINTING GIVEN ARRAY VALUES
        printGivenArray(selArr);

        // INITIALIZING VARIABLES
        int temp = Integer.MIN_VALUE;
        int smallNum = Integer.MIN_VALUE;
        int pos = Integer.MIN_VALUE;

        // A LOOP FOR ITERATIONS
        for (int i = 0; i < selArr.length; i++) {
            // INITIALIZING A BOOLEAN VARIABLE IN A LOOP EACH ITERATIONS
            // ASSIGNING THE LATEST numS AT INDEX i TO THE smallestNum
            smallNum = selArr[i];
            // LOOP FOR COMPARISON
            for (int j = i; j < selArr.length; j++) {
                // A CONDITION TO COMPARE ELEMENTS IN EACH ITERATIONS TO THE VARIABLE
                if (selArr[j] <= smallNum) {
                    // ASSIGNING numS AND ITERATOR IN A VARIABLE
                    smallNum = selArr[j];
                    pos = j;
                }
            }

            // SWAPPING OF ELEMENTS
            temp = selArr[i];
            selArr[i] = smallNum;
            selArr[pos] = temp;

            // A CONDITION TO BREAK IF ARRAY REACHES THE FINAL INDEX
            // if (i == selArr.length - 1) {
            // break;
            // }

            // PRINTING ARRAYS IN EACH ITERATIONS
            printIteratedArray(selArr, i);

            // COMPARES ARRAY TO SORTED ARRAY
            if (Arrays.equals(selArr, autoSorter(autoArr))) {
                break;
            }
        }

        // PRINTING THE SORTED OUTPUT
        printOutputArray(selArr);

    }

    // INSERTION SORT METHOD
    public static void insertionSort(int[] insArr, int[] autoArr) {

        // PRINTING THE GIVEN ARRAY VALUES
        printGivenArray(insArr);

        // INITIALIZING VARIABLES
        int temp = Integer.MIN_VALUE;
        int counter = Integer.MIN_VALUE;
        int iCounter = Integer.MIN_VALUE;

        // LOOP FOR ITERATIONS
        for (int i = 0; i < insArr.length; i++) {
            // ASSIGNING i TO iCounter
            iCounter = i;
            // A CONDITION IF i IS NOT EQUAL TO LENGTH - 1 THEN INCREMENT counter BY i+1
            if (i != insArr.length - 1) {
                counter = i + 1;
            }
            // A CONDITION OF i IS NOT EQUAL TO 0 THEN START PRINTING THE ARRAYS
            if (i != 0) {
                // PRINTING ARRAYS IN EACH ITERATIONS
                printIteratedArray(insArr, i - 1);
            }

            // COMPARES ARRAY TO SORTED ARRAY
            if (Arrays.equals(insArr, autoSorter(autoArr))) {
                printOutputArray(insArr);
                break;
            }

            // A LOOP TO COMPARE EACH ELEMENTS
            while (insArr[counter] < insArr[iCounter]) {
                // SWAPPING OF ELEMENTS
                temp = insArr[counter];
                insArr[counter] = insArr[iCounter];
                insArr[iCounter] = temp;

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
        while (true) {
            System.out.println("========================================================");
            System.out.print("Exit the Program? [Y/N]: ");
            String exit = scanner.nextLine();

            if (exit.toLowerCase().equals("n")) {
                System.out.println("========================================================");
                System.out.println("Returning to the Program.");
                System.out.println("========================================================");
                break;
            } else if (exit.toLowerCase().equals("y")) {
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

        boolean sizeExc = true;
        int size = 0;
        while (sizeExc) {
            do {
                try {
                    System.out.print("Enter Array Size: ");
                    size = scanner.nextInt();
                    System.out.println("========================================================");
                    if (size >= 4 && size <= 15) {
                        sizeExc = false;
                        break;
                    } else {
                        System.out.println("Invalid size. Try Again.");
                        continue;
                    }
                } catch (Exception e) {
                    System.out.println("========================================================");
                    System.out.println("Invalid Input. Try Again.");
                    System.out.println("========================================================");
                    scanner.next();
                }
            } while (size < 4 || size > 15);
        }
        final int[] num = new int[size];

        boolean elemExc = true;
        int eCounter = 0;
        while (elemExc) {
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
            boolean choiceExc = true;
            while (choiceExc) {
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

            int[] bubArr = new int[size];
            int[] selArr = new int[size];
            int[] insArr = new int[size];
            int[] autoArr = new int[size];

            for (int i = 0; i < size; i++) {
                bubArr[i] = num[i];
                selArr[i] = num[i];
                insArr[i] = num[i];
                autoArr[i] = num[i];
            }

            switch (choice) {
                case 1:
                    bubbleSort(bubArr, autoArr);
                    break;
                case 2:
                    selectionSort(selArr, autoArr);
                    break;
                case 3:
                    insertionSort(insArr, autoArr);
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

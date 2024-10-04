package DSAPLP4;

public class SortingClass {
    private String givenArray;
    private String sortedArray;

    public void bubbleSort(int[] numB) {

        // FOR PRINTING GIVEN ARRAY VALUES
        System.out.println("==================================");
        System.out.println("Bubble Sort");
        givenArray = "Given Array Elements: ";
        for (int i = 0; i < numB.length; i++) {
            givenArray += numB[i] + " ";
        }
        System.out.println(givenArray);
        //

        // INITIALIZING VARIABLES
        int temp = Integer.MIN_VALUE;
        int iCounter = 0;
        //

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
            //
        }

        // PRINTING THE SORTED OUTPUT
        sortedArray = "The Sorted Array Elements: ";
        for (int i = 0; i < numB.length; i++) {
            sortedArray += numB[i] + " ";
        }
        System.out.println(sortedArray);
        System.out.println("==================================");
    }

    public void selectionSort(int[] numS) {
        System.out.println("==================================");
        System.out.println("Selection Sort");
        givenArray = "Given Array Elements: ";
        for (int i = 0; i < numS.length; i++) {
            givenArray += numS[i] + " ";
        }
        System.out.println(givenArray);

        int temp = Integer.MIN_VALUE;
        int smallestNum = Integer.MIN_VALUE;
        int position = Integer.MIN_VALUE;

        for (int i = 0; i < numS.length; i++) {
            boolean arrayInOrder = true;
            smallestNum = numS[i];
            for (int j = i; j < numS.length; j++) {
                if (numS[j] <= smallestNum) {
                    smallestNum = numS[j];
                    position = j;
                    arrayInOrder = false;
                }
            }
            if (arrayInOrder == true) {
                break;
            }
            temp = numS[i];
            numS[i] = smallestNum;
            numS[position] = temp;
            if (i + 1 == numS.length) {
                break;
            }
            String iteratedArray = (i + 1) + ". ";
            for (int j = 0; j < numS.length; j++) {
                iteratedArray += numS[j] + " ";
            }
            System.out.println(iteratedArray);
        }
        sortedArray = "The Sorted Array Elements: ";
        for (int i = 0; i < numS.length; i++) {
            sortedArray += numS[i] + " ";
        }
        System.out.println(sortedArray);
        System.out.println("==================================");
    }

    public void insertionSort(int[] numI) {
        System.out.println("==================================");
        System.out.println("Insertion Sort");
        givenArray = "Given Array Elements: ";
        for (int i = 0; i < numI.length; i++) {
            givenArray += numI[i] + " ";
        }
        System.out.println(givenArray);

        int temp = Integer.MIN_VALUE;
        int counter = Integer.MIN_VALUE;
        int iCounter = Integer.MIN_VALUE;

        for (int i = 0; i < numI.length; i++) {
            iCounter = i;
            if (i != numI.length - 1) {
                counter = i + 1;
            }
            if (i != 0) {
                String iteratedArray = iCounter + ". ";
                for (int j = 0; j < numI.length; j++) {
                    iteratedArray += numI[j] + " ";
                }
                System.out.println(iteratedArray);
            }
            if (i == numI.length - 1) {
                sortedArray = "The Sorted Array Elements: ";
                for (int k = 0; k < numI.length; k++) {
                    sortedArray += numI[k] + " ";
                }
                System.out.println(sortedArray);
                System.out.println("==================================");
                break;
            }
            while (numI[counter] < numI[iCounter]) {
                temp = numI[counter];
                numI[counter] = numI[iCounter];
                numI[iCounter] = temp;
                if (iCounter != 0 && counter != 0) {
                    iCounter--;
                    counter--;
                } else {
                    break;
                }
            }
        }
    }

    public void exit() {
        System.out.println("Exiting the program.");
    }
}

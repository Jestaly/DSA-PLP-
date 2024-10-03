package DSAPLP4;

public class SortingClass {
    private String givenArray;
    private String sortedArray;

    public void bubbleSort(int[] numBubbleSort) {
        System.out.println("==================================");
        System.out.println("Bubble Sort");
        givenArray = "Given Array Elements: ";
        for (int i = 0; i < numBubbleSort.length; i++) {
            givenArray += numBubbleSort[i] + " ";
        }
        System.out.println(givenArray);

        int temp = Integer.MIN_VALUE;
        int iCounter = 0;

        for (int i = 0; i < numBubbleSort.length; i++) {
            for (int j = 1; j < numBubbleSort.length; j++) {
                if (numBubbleSort[iCounter] > numBubbleSort[j]) {
                    temp = numBubbleSort[iCounter];
                    numBubbleSort[iCounter] = numBubbleSort[j];
                    numBubbleSort[j] = temp;
                }
                iCounter++;
            }
            iCounter = 0;
            if (i + 1 == numBubbleSort.length) {
                break;
            }
            String iteratedArray = (i + 1) + ". ";
            for (int j = 0; j < numBubbleSort.length; j++) {
                iteratedArray += numBubbleSort[j] + " ";
            }
            System.out.println(iteratedArray);
        }
        sortedArray = "The Sorted Array Elements: ";
        for (int i = 0; i < numBubbleSort.length; i++) {
            sortedArray += numBubbleSort[i] + " ";
        }
        System.out.println(sortedArray);
        System.out.println("==================================");
    }

    public void selectionSort(int[] numSelectionSort) {
        System.out.println("==================================");
        System.out.println("Selection Sort");
        givenArray = "Given Array Elements: ";
        for (int i = 0; i < numSelectionSort.length; i++) {
            givenArray += numSelectionSort[i] + " ";
        }
        System.out.println(givenArray);

        int temp = Integer.MIN_VALUE;
        int smallestNum = Integer.MIN_VALUE;
        int position = Integer.MIN_VALUE;

        for (int i = 0; i < numSelectionSort.length; i++) {
            boolean arrayInOrder = true;
            smallestNum = numSelectionSort[i];
            for (int j = i; j < numSelectionSort.length; j++) {
                if (numSelectionSort[j] <= smallestNum) {
                    smallestNum = numSelectionSort[j];
                    position = j;
                    arrayInOrder = false;
                }
            }
            if (arrayInOrder == true) {
                break;
            }
            temp = numSelectionSort[i];
            numSelectionSort[i] = smallestNum;
            numSelectionSort[position] = temp;
            if (i + 1 == numSelectionSort.length) {
                break;
            }
            String iteratedArray = (i + 1) + ". ";
            for (int j = 0; j < numSelectionSort.length; j++) {
                iteratedArray += numSelectionSort[j] + " ";
            }
            System.out.println(iteratedArray);
        }
        sortedArray = "The Sorted Array Elements: ";
        for (int i = 0; i < numSelectionSort.length; i++) {
            sortedArray += numSelectionSort[i] + " ";
        }
        System.out.println(sortedArray);
        System.out.println("==================================");
    }

    public void insertionSort(int[] numInsertionSort) {
        System.out.println("==================================");
        System.out.println("Insertion Sort");
        givenArray = "Given Array Elements: ";
        for (int i = 0; i < numInsertionSort.length; i++) {
            givenArray += numInsertionSort[i] + " ";
        }
        System.out.println(givenArray);

        int temp = Integer.MIN_VALUE;
        int counter = Integer.MIN_VALUE;
        int iCounter = Integer.MIN_VALUE;

        for (int i = 0; i < numInsertionSort.length; i++) {
            iCounter = i;
            if (i != numInsertionSort.length - 1) {
                counter = i + 1;
            }
            if (i != 0) {
                String iteratedArray = iCounter + ". ";
                for (int j = 0; j < numInsertionSort.length; j++) {
                    iteratedArray += numInsertionSort[j] + " ";
                }
                System.out.println(iteratedArray);
            }
            if (i == numInsertionSort.length - 1) {
                sortedArray = "The Sorted Array Elements: ";
                for (int k = 0; k < numInsertionSort.length; k++) {
                    sortedArray += numInsertionSort[k] + " ";
                }
                System.out.println(sortedArray);
                System.out.println("==================================");
                break;
            }
            while (numInsertionSort[counter] < numInsertionSort[iCounter]) {
                temp = numInsertionSort[counter];
                numInsertionSort[counter] = numInsertionSort[iCounter];
                numInsertionSort[iCounter] = temp;
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

package DSAPLP4;

import java.util.Arrays;

public class SortingClass {
    private String givenArray;
    private String sortedArray;

    public void bubbleSort(int[] num) {
        System.out.println("==================================");
        System.out.println("Bubble Sort");
        givenArray = "Given Array Elements: ";
        for (int i = 0; i < num.length; i++) {
            givenArray += num[i] + " ";
        }
        System.out.println(givenArray);
        int temp = Integer.MIN_VALUE;
        int iCounter = 0;
        for (int i = 0; i < num.length; i++) {
            for (int j = 1; j < num.length; j++) {
                if (num[iCounter] > num[j]) {
                    temp = num[iCounter];
                    num[iCounter] = num[j];
                    num[j] = temp;
                }
                iCounter++;
            }
            iCounter = 0;
            if (i + 1 == num.length) {
                break;
            }
            String iteratedArray = (i + 1) + ". ";
            for (int j = 0; j < num.length; j++) {
                iteratedArray += num[j] + " ";
            }
            System.out.println(iteratedArray);
        }
        sortedArray = "The Sorted Array Elements: ";
        for (int i = 0; i < num.length; i++) {
            sortedArray += num[i] + " ";
        }
        System.out.println(sortedArray);
        System.out.println("==================================");
    }

    public void selectionSort(int[] num) {
        System.out.println("==================================");
        System.out.println("Selection Sort");
        givenArray = "Given Array Elements: ";
        for (int i = 0; i < num.length; i++) {
            givenArray += num[i] + " ";
        }
        System.out.println(givenArray);
        int temp = Integer.MIN_VALUE;
        int smallestNum = Integer.MIN_VALUE;
        int position = Integer.MIN_VALUE;
        for (int i = 0; i < num.length; i++) {
            boolean arrayInOrder = true;
            smallestNum = num[i];
            for (int j = i; j < num.length; j++) {
                if (num[j] <= smallestNum) {
                    smallestNum = num[j];
                    position = j;
                    arrayInOrder = false;
                }
            }
            if (arrayInOrder == true) {
                break;
            }
            temp = num[i];
            num[i] = smallestNum;
            num[position] = temp;

            if (i + 1 == num.length) {
                break;
            }
            String iteratedArray = (i + 1) + ". ";
            for (int j = 0; j < num.length; j++) {
                iteratedArray += num[j] + " ";
            }
            System.out.println(iteratedArray);
        }
        sortedArray = "The Sorted Array Elements: ";
        for (int i = 0; i < num.length; i++) {
            sortedArray += num[i] + " ";
        }
        System.out.println(sortedArray);
        System.out.println("==================================");
    }

    public void insertionSort(int[] num) {
        System.out.println("==================================");
        System.out.println("Insertion Sort");
        givenArray = "Given Array Elements: ";
        for (int i = 0; i < num.length; i++) {
            givenArray += num[i] + " ";
        }
        System.out.println(givenArray);
        int temp = Integer.MIN_VALUE;
        int counter = Integer.MIN_VALUE;
        int iCounter = Integer.MIN_VALUE;
        for (int i = 0; i < num.length; i++) {
            iCounter = i;
            if (i != num.length - 1) {
                counter = i + 1;
            }
            if (i != 0) {
                String iteratedArray = iCounter + ". ";
                for (int j = 0; j < num.length; j++) {
                    iteratedArray += num[j] + " ";
                }
                System.out.println(iteratedArray);
            }
            if (i == num.length - 1) {
                sortedArray = "The Sorted Array Elements: ";
                for (int k = 0; k < num.length; k++) {
                    sortedArray += num[k] + " ";
                }
                System.out.println(sortedArray);
                System.out.println("==================================");
                break;
            }
            while (num[counter] < num[iCounter]) {
                temp = num[counter];
                num[counter] = num[iCounter];
                num[iCounter] = temp;
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

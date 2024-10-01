package DSAPLP4;

import java.util.Arrays;

public class SortingClass {

    public int[] bubbleSort(int[] num) {
        System.out.println("Bubble Sort");
        for (int i = 0; i < num.length; i++) {
            if (i == 0) {
                System.out.println("Given Array Elements: ");
            }
            System.out.print(num[i] + " ");
        }
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
            System.out.println((i + 1) + ". ");
            for (int j = 0; j < num.length; j++) {
                System.out.print(num[j] + " ");
            }
        }
        return num;
    }

    public int[] selectionSort(int[] num) {
        System.out.println("This is a selection sort.");
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
            for (int j = 0; j < num.length; j++) {
                System.out.print((i + 1) + ". " + num[j] + " ");
            }
        }
        return num;
    }

    public int[] insertionSort(int[] num) {
        System.out.println("This is an insertion sort.");
        int temp = Integer.MIN_VALUE;
        int counter = Integer.MIN_VALUE;
        int iCounter = Integer.MIN_VALUE;
        for (int i = 0; i < num.length; i++) {
            iCounter = i;
            if (i != num.length - 1) {
                counter = i + 1;
            }
            if (i != 0) {
                System.out.println((iCounter) + ". " + Arrays.toString(num));
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
        return num;
    }

    public void exit() {
        System.out.println("Exiting the program.");
    }
}

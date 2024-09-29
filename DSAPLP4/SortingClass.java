package DSAPLP4;

import java.util.Arrays;

public class SortingClass {

    public int[] bubbleSort(int[] num) {

        System.out.println("this a bubble sort.");
        int temp = Integer.MIN_VALUE;
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num.length; j++) {
                if (num[j] > num[i]) {
                    temp = num[j];
                    num[j] = num[i];
                    num[i] = temp;
                }
                System.out.println(Arrays.toString(num));
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
            System.out.println(Arrays.toString(num));
        }
        return num;
    }

    public String insertionSort(int[] num) {
        int temp = 0;
        System.out.println("This is an insertion sort.");

        for (int i = 0; i < num.length; i++) {

        }
        return Arrays.toString(num);
    }

    public void exit() {
        System.out.println("Exiting the program.");
    }
}

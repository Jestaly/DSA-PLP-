package DSAPLP4;

import java.util.Arrays;

public class SortingClass {

    public String bubbleSort(int[] num) {
        int temp = Integer.MIN_VALUE;
        System.out.println("this a bubble sort.");
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num.length; j++) {
                if (num[j] > num[i]) {
                    temp = num[j];
                    num[j] = num[i];
                    num[i] = temp;
                    System.out.println(Arrays.toString(num));
                }
            }
        }
        return Arrays.toString(num);
    }

    public String selectionSort(int[] num) {
        int temp = 0;
        int smallestNum = 0;
        int position = 0;
        System.out.println("This is a selection sort.");
        for (int i = 0; i < num.length; i++) {
            smallestNum = num[i];
            for (int j = i; j < num.length; j++) {
                if (num[j] < smallestNum) {
                    smallestNum = num[j];
                    position = j;
                }
            }
            temp = num[i];
            num[i] = smallestNum;
            num[position] = temp;
            System.out.println(Arrays.toString(num));

        }
        return Arrays.toString(num);
    }

    public int[] insertionSort(int[] num) {
        int temp = 0;
        System.out.println("This is an insertion sort.");
        for (int i = 0; i < num.length; i++) {

        }
        return num;
    }

    public void exit() {
        System.out.println("Exiting the program.");
    }
}

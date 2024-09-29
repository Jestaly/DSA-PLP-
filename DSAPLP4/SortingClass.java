package DSAPLP4;

import java.util.Arrays;

public class SortingClass {

    private int[] num;

    public int[] bubbleSort(int[] num) {

        System.out.println("this a bubble sort.");
        this.num = num;
        int temp = Integer.MIN_VALUE;
        for (int i = 0; i < this.num.length; i++) {
            for (int j = 0; j < this.num.length; j++) {
                if (this.num[j] > this.num[i]) {
                    temp = this.num[j];
                    this.num[j] = this.num[i];
                    this.num[i] = temp;
                }
            }
        }
        return this.num;
    }

    public int[] selectionSort(int[] num) {

        System.out.println("This is a selection sort.");
        this.num = num;
        int temp = Integer.MIN_VALUE;
        int smallestNum = Integer.MIN_VALUE;
        int position = Integer.MIN_VALUE;
        for (int i = 0; i < this.num.length; i++) {
            @SuppressWarnings("unused")
            boolean arrayInOrder = true;
            smallestNum = this.num[i];
            for (int j = i; j < this.num.length; j++) {
                if (this.num[j] <= smallestNum) {
                    smallestNum = this.num[j];
                    position = j;
                    arrayInOrder = false;
                }
            }
            if (arrayInOrder = true) {
                break;
            }
            temp = this.num[i];
            this.num[i] = smallestNum;
            this.num[position] = temp;
        }
        return this.num;
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

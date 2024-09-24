package DSAPLP4;

public class SortingClass {

    SortingClass() {

    }

    public int[] bubbleSort(int[] num) {
        int temp = Integer.MIN_VALUE;
        System.out.println("this a bubble sort.");
        for (int i = 1; i < num.length; i++) {
            if (num[i - 1] > num[i]) {
                temp = num[i];
            }
        }
        return num;
    }

    public int[] selectionSort(int[] num) {
        int temp = 0;
        System.out.println("This is a selection sort.");
        for (int i = 0; i < num.length; i++) {
        }
        return num;
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

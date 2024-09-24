package DSAPLP4;

public class SortingClass {

    SortingClass() {

    }

    public int[] bubbleSort(int[] num) {
        System.out.println("this a bubble sort.");
        for (int i = 0; i < num.length; i++) {
            System.out.println(i);
        }
        return num;
    }

    public int[] selectionSort(int[] num) {
        System.out.println("This is a selection sort.");
        for (int i = 0; i < num.length; i++) {
        }
        return num;
    }

    public int[] insertionSort(int[] num) {
        System.out.println("This is a selection sort.");
        for (int i = 0; i < num.length; i++) {

        }
        return num;
    }

    public void exit() {
        System.out.println("Exiting the program.");
    }
}

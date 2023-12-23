package GreetArgorithms;

import java.util.Arrays;
import java.util.Stack;

public class Greet {
    public static void main(String[] args) {
        int[] array = {50, 20, 10, 5, 2, 1};
        bubble_sort(array);
        System.out.println(Arrays.toString(array));
    }

    static void bubble_sort(int[] array) {
        sort(array, array.length);
    }

    static void sort(int[] arr, int n) {
        if (n == 1) {
            return;
        }

        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }

        sort(arr, n - 1); // Recursively sort the remaining elements
    }
    static int divide(int number, int[] array) {
        int result = number; // initialize the result with the number
        for (int j : array) { // loop through the array elements
            if (j == 0) { // check if the element is zero
                return 0; // return zero to avoid division by zero
            }
            result = result / j; // divide the result by the element
        }
        return result; // return the final result
    }


}






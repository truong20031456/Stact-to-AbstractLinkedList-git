package Bubble_sort;

import java.util.Arrays;

public class bubbleSort {
    public static void main(String[] args) {
        int[] array = {1, 12, 13, 15, 7, 9, 5, 154, 45};
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
}

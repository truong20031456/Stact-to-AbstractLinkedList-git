package mergeSort;

public class Main {
    public static void main(String[] args) {
        int[] array = {10, 5, 2, 3, 1, 9, 7, 8, 4, 6};
        mergeSort(array, array.length);
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    static void mergeSort(int[] array, int size) {
        if (size < 2) {
            return;
        }
        int mid = size / 2;
        int[] left = new int[mid];
        int[] right = new int[size - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = array[i];
        }
        for (int i = mid; i < size; i++) {
            right[i - mid] = array[i];
        }
        mergeSort(left, mid);
        mergeSort(right, size - mid);

        merge(array, left, right, mid, size - mid);
    }

    static void merge(int[] array, int[] left, int[] right, int leftSize, int rightSize) {
        int i = 0, j = 0, k = 0;
        while (i < leftSize && j < rightSize) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }
        while (i < leftSize) {
            array[k++] = left[i++];
        }
        while (j < rightSize) {
            array[k++] = right[j++];
        }
    }
}

package Quick_sort;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = {12, 7, 3, 9, 2, 5};

        // Call quicksort
        quickSort(array, 0, array.length - 1);

        // Print the sorted array
        for (int num : array) {
            System.out.print(num + " ");
        }
    }

    static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            // Partition the array
            int pivotIndex = partition(array, low, high);

            // Recursively sort elements before and after the partition
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    static int partition(int[] array, int low, int high) {
        // Choose the pivot (last element in this case)
        int pivot = array[high];
        int i = low - 1;

        // Rearrange elements smaller than pivot to the left and greater to the right
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                // Swap array[i] and array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // Swap array[i+1] and array[high] (pivot)
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1; // Return the partitioning index
    }
}

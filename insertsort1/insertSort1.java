package insertsort1;

public class insertSort1 {
    public static void main(String[] args) {
        int[] array = {1, 2, 5, 4, 68, 6, 4};

        // Call the insertion sort method
        insertSort(array);

        // Print the sorted array
        for (int num : array) {
            System.out.print(num + " ");
        }
    }

    static void insertSort(int[] array) {
        int temp;
        for (int i = 1; i < array.length; i++) {
            temp = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > temp) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }
    }
}

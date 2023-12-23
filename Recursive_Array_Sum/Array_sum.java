package Recursive_Array_Sum;

public class Array_sum {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int result = sum(array, array.length - 1);
        System.out.println(result);
    }

    static int sum(int[] array, int index){
        if(index < 0){
            return 0;
        }
        return array[index] + sum(array, index - 1);
    }
}

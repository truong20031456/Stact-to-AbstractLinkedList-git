package Loo_Recursion;

public class Helper {
    public static void main(String[] args) {
        int[] array ={1,2,3,4,5};

    }
    static int sum(int[] array,int index){
        if (index== array.length -1){
            return array[index];// Base condition

        }
       return array[index] + sum(array, index +1);// recurrence relation




    }
}

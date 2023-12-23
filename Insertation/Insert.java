package Insertation;

public class Insert {
    public static void main(String[] args) {
        int[]array = {17,23,45,18,12,22};
    }




    static void insertNumber(int[] array) {

        for (int i = 0; i < array.length; i++) {
      int  current=array[i];
            int j= i-1;
            while (j>=0&&array[j] >current){
                array[j+1] =array[j];
                i--;
            }
            array[j+1]=current;

        }


    }
}








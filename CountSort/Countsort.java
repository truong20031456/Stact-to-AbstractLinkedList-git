package CountSort;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Countsort {
    public static void main(String[] args) {
        int [] array = {6,5,3,2,3,4,5,6,7,9,5,10,15,14,11,20,8};
        var sorter = new Countsort();
        countSort(array, array.length);
        System.out.println(Arrays.toString(array));

    }
   static void countSort(int[]array,int max){
        int[] count= new int [max+1];
        for(int item:array){
            count[item]++;
        }
        int k = 0;
      for (int i =0;i< count.length;i++){
          for(int j=0;j<count[i];i++){
              array[ k ]=i;
          }
          k++;
      }



   }


}


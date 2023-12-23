package Generating_01_Vector;

public class generateVector {
    public static void main(String[] args) {
        int[] vector= new int[2];
        generateVector1(vector,0);
    }
    static void generateVector1(int[] vector, int index) {
        if (index == vector.length)
        {
            display(vector);
            return;
        }
        for(int i =0; i<=1;i++){    // Generate the value for the current index
            vector[index] = i /* Your value here */;
        // Recursively generate the rest of the vector
        generateVector1(vector, index + 1);

    }}
    static void display(int[] vector){
        for (int j : vector) {
            System.out.println(j);
        }
    }



}


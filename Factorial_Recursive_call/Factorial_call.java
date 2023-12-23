package Factorial_Recursive_call;

public class Factorial_call {
    public static void main(String[] args) {
        int result = factorial(4);
        System.out.println(result);
    }

    static int factorial(int n){
        if(n == 0){
            return 1;
        }
        return n * factorial(n - 1);
    }
}
